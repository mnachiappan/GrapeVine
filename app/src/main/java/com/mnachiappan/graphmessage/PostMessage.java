package com.mnachiappan.graphmessage;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
* Created by meyyappan.nachiappan on 15-02-22.
*/
public class PostMessage extends AsyncTask<Conversation, Void, List<JSONObject>> {


    private Context mContext;
    private ConversationAdapter mAdapter;
    public PostMessage (Context context, ConversationAdapter adapter){
        mContext = context;
        mAdapter = adapter;
    }

    @Override
    protected List<JSONObject> doInBackground(Conversation... params) {
        JSONParser jParser = new JSONParser();
        List<JSONObject> jsonResults = new ArrayList<JSONObject>();
        for (int i = 0; i < params.length; i++) {
            final Conversation convo = params[i];
            NameValuePair author = new NameValuePair() {
                @Override
                public String getName() {
                    return "author";
                }

                @Override
                public String getValue() {
                    return convo.getAuthor();
                }
            };
            NameValuePair status = new NameValuePair() {
                @Override
                public String getName() {
                    return "status";
                }

                @Override
                public String getValue() {
                    return convo.getMessage();
                }
            };
            List<NameValuePair> paramsPost = new ArrayList<NameValuePair>();
            paramsPost.add(author);
            paramsPost.add(status);
            jsonResults.add(jParser.makeHttpRequest("http://www.statuses.bugs3.com/create_row.php", "POST", paramsPost));
        }
        Log.v("Tag", jsonResults.get(0).toString());
        return jsonResults;
    }

    @Override
    protected void onPostExecute(List<JSONObject> objects) {
        datasource db = new datasource(mContext);
        db.open();
        for (int i = 0; i < objects.size(); i++){
            JSONObject obj = objects.get(i);
            try {
                db.createConversation(obj.getString("message"), obj.getString("author"), obj.getLong("id"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        db.close();
        GetMessages getMsg = new GetMessages(mContext, mAdapter);

        if (mAdapter.getCount() == 0) {
            getMsg.execute(0L);
        }
        else {
            getMsg.execute(mAdapter.getItem(mAdapter.getCount() - 1).getDate());
        }

    }
}
