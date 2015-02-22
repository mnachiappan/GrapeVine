package com.mnachiappan.graphmessage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class datasource {

    // Database fields
    private SQLiteDatabase database;
    private SQLdb dbHelper;
    private String[] allColumns = {SQLdb.COLUMN_ID,
            SQLdb.COLUMN_AUTHOR, SQLdb.COLUMN_STATUS, SQLdb.COLUMN_TIME};

    public datasource(Context context) {
        dbHelper = new SQLdb(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long createConversation(String author, String status, String time) {
        ContentValues values = new ContentValues();
        values.put(SQLdb.COLUMN_AUTHOR, author);
        values.put(SQLdb.COLUMN_STATUS, status);
        values.put(SQLdb.COLUMN_TIME, status);
        long insertId = database.insert(SQLdb.TABLE_COMMENTS, null,
                values);
        return insertId;
    }

    public Conversation getConvo(long insertId) {
        Cursor cursor = database.query(SQLdb.TABLE_COMMENTS,
                allColumns, SQLdb.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Conversation newConvo = cursorToConvo(cursor);
        cursor.close();
        return newConvo;
    }

    private Conversation cursorToConvo(Cursor cursor) {
        Conversation convo = new Conversation();
        convo.setId(cursor.getLong(0));
        convo.setAuthor(cursor.getString(1));
        convo.setMessage(cursor.getString(2));
        convo.setDate(cursor.getLong(3));
        return convo;
    }

}
