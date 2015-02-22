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
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class ConversationFragment extends Fragment {

    private ArrayAdapter<String> mAdapter;

    public ConversationFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        String[] conversations = new String[] {"Hello", "Bye"};
        List<String> conversationsList = new ArrayList<String>(Arrays.asList(conversations));

        // create ListView
//        ListView listView = (ListView) rootView.findViewById(R.id.listview_conversation);
        // create adapter
//        mAdapter = new ArrayAdapter<String>(this.getActivity(), R.layout.list_item_conversation, R.id.list_item_conversation_textview, conversationsList);
        // hook adapter with ListView
//        listView.setAdapter(mAdapter);
        return rootView;
    }
}