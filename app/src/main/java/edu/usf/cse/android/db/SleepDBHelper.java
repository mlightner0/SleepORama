package edu.usf.cse.android.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Alex on 10/20/2015.
 */
public class SleepDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "SleepORama";
    private static final int DB_VERSION = 1;

    public SleepDBHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
}
