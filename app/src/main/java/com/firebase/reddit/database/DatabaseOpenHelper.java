package com.firebase.reddit.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ahmad on 20/01/2017.
 */

public class DatabaseOpenHelper extends SQLiteOpenHelper {

    /**
     * DATABASE VERSION
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * TABLE STRINGS
     */
    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA = ", ";

    /**
     * SQL CREATE TABLE
     */
    private static final String CREATE_TAMPIL_TABLE = "CREATE TABLE "
            +DatabaseConstract.TampilTable.TABLE_NAME + " ("
            +DatabaseConstract.TampilTable.TITLE + TEXT_TYPE + COMMA
            +DatabaseConstract.TampilTable.LINK + TEXT_TYPE + COMMA
            +DatabaseConstract.TampilTable.IMAGELINK + TEXT_TYPE + " )";

    public static final String DROP_TAMPIL_TABLE = "DROP TABLE IF EXISTS "+DatabaseConstract.TampilTable.TABLE_NAME;

    public DatabaseOpenHelper(Context context) {
        super(context, DatabaseConstract.DB_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TAMPIL_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TAMPIL_TABLE);
        onCreate(db);
    }
}
