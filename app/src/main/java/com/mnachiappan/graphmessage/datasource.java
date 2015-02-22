package com.mnachiappan.graphmessage;

import java.util.ArrayList;

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

    public long createConversation(String author, String status, long time) {
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

    public ArrayList<Conversation> getAllConversation(long time) {
        ArrayList<Conversation> comments = new ArrayList<Conversation>();

        Cursor cursor = database.query(SQLdb.TABLE_COMMENTS,
                allColumns, SQLdb.COLUMN_TIME + " > " + time, null,
                null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Conversation convo = cursorToConvo(cursor);
            comments.add(convo);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return comments;
    }

    public void deleteAllComment() {
//        ArrayList<Conversation> ac = getAllConversation(time);
//
//        for (Conversation comment : ac) {
//            long id = comment.getId();
//            System.out.println("Comment deleted with id: " + id);
//            database.delete(SQLdb.TABLE_COMMENTS, SQLdb.COLUMN_ID
//                    + " = " + id, null);
//        }
        dbHelper.onUpgrade(database, 1, 2);
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
