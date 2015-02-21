package com.mnachiappan.graphmessage;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SQLdb extends SQLiteOpenHelper  {

    public static final String TABLE_COMMENTS = "statuses";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_AUTHOR = "author";
    public static final String COLUMN_STATUS= "status";
    public static final String COLUMN_TIME= "time";

    private static final String DATABASE_NAME = "statuses.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE = "create table "
            + TABLE_COMMENTS + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_AUTHOR
            + " text not null, "+ COLUMN_STATUS + " text not null, "+ COLUMN_TIME + " text not null  );";
}
