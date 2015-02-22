package com.mnachiappan.graphmessage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by meyyappan.nachiappan on 15-02-21.
 */
public class ConversationAdapter extends ArrayAdapter<Conversation> {
    private ArrayList<Conversation> mConversations;

    public ConversationAdapter(Context context, int textViewResourceId, ArrayList<Conversation> mConversations) {
        super(context, textViewResourceId, mConversations);
        this.mConversations = mConversations;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_item_conversation, null);
        }
        Conversation i = mConversations.get(position);
        if (i != null) {
            TextView conversation_text = (TextView) v.findViewById(R.id.list_item_conversation_textview);
            TextView date_text = (TextView) v.findViewById(R.id.list_item_conversation_date);
            TextView author_text = (TextView) v.findViewById(R.id.list_item_conversation_author);
            conversation_text.setText(i.getMessage());
            date_text.setText(i.getDate().toString());
            author_text.setText(i.getAuthor());

        }
        return v;
    }
}
