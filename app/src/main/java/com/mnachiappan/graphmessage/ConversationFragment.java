package com.mnachiappan.graphmessage;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.apache.http.NameValuePair;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */

public class ConversationFragment extends Fragment {

    private ConversationAdapter mAdapter;

    public ConversationFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        Conversation[] conversations = new Conversation[] {
                new Conversation("fjdskl", "fjdlsk", 21),
                new Conversation("conversation2", "author", 21),

        };
        ArrayList<Conversation> conversationsList = new ArrayList<Conversation>(Arrays.asList(conversations));

        // create ListView
        ListView listView = (ListView) rootView.findViewById(R.id.listview_conversation);
        // create adapter
        //mAdapter = new ArrayAdapter<String>(this.getActivity(), R.layout.list_item_conversation, R.id.list_item_conversation_textview, conversationsList);
        // hook adapter with ListView
        mAdapter = new ConversationAdapter(this.getActivity(), R.layout.list_item_conversation, conversationsList);
        listView.setAdapter(mAdapter);
        Button sendButton = (Button) rootView.findViewById(R.id.sendBtn);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText messageText = (EditText) rootView.findViewById(R.id.messageBox);
                Conversation convo = new Conversation(messageText.getText().toString(), "Chair", 1);
                PostMessage post = new PostMessage(getActivity(), mAdapter);
                post.execute(convo);
                messageText.clearFocus();
                messageText.setText("");

            }

        });
        Button refreshButton = (Button) rootView.findViewById(R.id.refreshBtn);
        refreshButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                GetMessages getMsg = new GetMessages(getActivity(), mAdapter);
                getMsg.execute(mAdapter.getItem(mAdapter.getCount() - 1).getDate());
            }
        });

        return rootView;

    }

    public class LoadAllProducts extends AsyncTask<String, String, String>{
        @Override
        protected String doInBackground(String... params1) {
            JSONParser jParser = new JSONParser();
            NameValuePair param = new NameValuePair() {
                @Override
                public String getName() {
                    return "_id";
                }

                @Override
                public String getValue() {
                    return "0";
                }
            };
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(param);
            JSONObject json = jParser.makeHttpRequest("http://www.statuses.bugs3.com/get_rows.php", "GET", params);
            NameValuePair author = new NameValuePair() {
                @Override
                public String getName() {
                    return "author";
                }

                @Override
                public String getValue() {
                    return "Meyyappan";
                }
            };
            NameValuePair status = new NameValuePair() {
                @Override
                public String getName() {
                    return "status";
                }

                @Override
                public String getValue() {
                    return "HellO";
                }
            };
            List<NameValuePair> paramsPost = new ArrayList<NameValuePair>();
            paramsPost.add(author);
            paramsPost.add(status);
            jParser.makeHttpRequest("http://www.statuses.bugs3.com/create_row.php", "POST", paramsPost);

            // http://www.statuses.bugs3.com/get_rows.php GET _id : 12
            NameValuePair id = new NameValuePair() {
                @Override
                public String getName() {
                    return "_id";
                }

                @Override
                public String getValue() {
                    return "14";
                }
            };
            paramsPost.add(id);
            JSONObject jsn = jParser.makeHttpRequest("http://www.statuses.bugs3.com/get_rows.php", "GET", paramsPost);
            Log.v("Tag", jsn.toString());
            // "http://www.statuses.bugs3.com/create_row
            //params:  author, status
            return json.toString();
        }

        protected void onPostExecute(String result) {
            //   Log.v("Tag", result);
        }
    }
}