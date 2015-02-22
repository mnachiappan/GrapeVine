package com.mnachiappan.graphmessage;

import java.util.Date;

/**
 * Created by meyyappan.nachiappan on 15-02-21.
 */
public class Conversation {

    private long id;
    private String mMessage;
    private String mAuthor;
    private long mDate;

    /*
    public Conversation (String mMessage, String mAuthor, Date mDate) {
        this.mMessage = mMessage;
        this.mAuthor = mAuthor;
        this.mDate = mDate;
    }
    */
    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        mAuthor = author;
    }

    public long getDate() {
        return mDate;
    }

    public void setDate(long date) {
        mDate = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
