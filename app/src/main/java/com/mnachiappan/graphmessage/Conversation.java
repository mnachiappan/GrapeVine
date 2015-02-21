package com.mnachiappan.graphmessage;

import java.util.Date;

/**
 * Created by meyyappan.nachiappan on 15-02-21.
 */
public class Conversation {
    private String mMessage;
    private String mAuthor;
    private Date mDate;

    public Conversation (String mMessage, String mAuthor, Date mDate) {
        this.mMessage = mMessage;
        this.mAuthor = mAuthor;
        this.mDate = mDate;
    }

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

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }
}
