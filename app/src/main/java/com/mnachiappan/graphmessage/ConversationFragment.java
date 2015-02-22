package com.mnachiappan.graphmessage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

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
        return rootView;
    }
}