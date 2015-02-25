package com.mnachiappan.graphmessage;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
* Created by meyyappan.nachiappan on 15-02-22.
*/
public class GetMessages extends AsyncTask<Long, Void, JSONObject> {
    private Context mContext;
    private ConversationAdapter mAdapter;
    public GetMessages(Context context, ConversationAdapter mAdapter) {
        mContext = context;
        this.mAdapter = mAdapter;
    }
    @Override
    protected JSONObject doInBackground(Long... params) {
        final long lastId = params[0];
        NameValuePair id = new NameValuePair() {
            @Override
            public String getName() {
                return "_id";
            }

            @Override
            public String getValue() {
                return String.valueOf(lastId);
            }
        };
        List<NameValuePair> paramsID = new ArrayList<NameValuePair>();
        paramsID.add(id);
        JSONParser jParser = new JSONParser();
        JSONObject jsn = jParser.makeHttpRequest("http://www.statuses.bugs3.com/get_rows.php", "GET", paramsID);

        return jsn;
    }

    @Override
    protected void onPostExecute(JSONObject object) {
        try {
            JSONArray convoArray = object.getJSONArray("convos");
            datasource db = new datasource(mContext);
            db.open();
            for (int i = 0; i < convoArray.length(); i++){
                JSONObject convoObj = convoArray.getJSONObject(i);
                String status = convoObj.getString("status");
                String author = convoObj.getString("author");
                long id = Long.parseLong(convoObj.getString("_id"));
                db.createConversation(author, status, id);
                Conversation convoAdd = new Conversation(status, author, id);
                convoAdd.timez = convoObj.getString("time");
                mAdapter.add(convoAdd);
            }
            db.close();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
