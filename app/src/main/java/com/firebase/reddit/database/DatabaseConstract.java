package com.firebase.reddit.database;

/**
 * Created by ahmad on 20/01/2017.
 */

public class DatabaseConstract {

    public static final String DB_NAME = "reddit_database.db";

    public abstract class TampilTable{
        public static final String TABLE_NAME = "tampil_table";

        public static final String TITLE = "title";
        public static final String LINK = "link";
        public static final String IMAGELINK = "imagelink";
    }
}
