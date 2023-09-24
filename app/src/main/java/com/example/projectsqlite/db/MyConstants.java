package com.example.projectsqlite.db;

public class MyConstants {
    public static final String TABLE_NAME = "entry";
    public static final String _ID = "_id";
    public static final String COLUMN_NAME_TITLE = "title";
    public static final String COLUMN_NAME_SUBTITLE = "disc";
    public static final String DB_NAME = "DATA.db";
    public static final int DB_VERSION = 1;

    public static final String TABLE_STRUCTURE = " CREATE TABLE IF NOT EXISTS " +
            TABLE_NAME + " (" + _ID + " INTEGER PRIMARY KEY, " + COLUMN_NAME_TITLE + " TEXT, " + COLUMN_NAME_SUBTITLE + " TEXT) ";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
}
