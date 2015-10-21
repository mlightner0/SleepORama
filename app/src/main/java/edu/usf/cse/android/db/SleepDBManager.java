package edu.usf.cse.android.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;

/**
 * Created by Alex on 10/20/2015.
 */
public class SleepDBManager {
    private Context context;
    private SQLiteDatabase db;
    private SleepDBHelper dbHelper;

    public SleepDBManager(Context context){
        this.context = context;
    }

    public void open() throws SQLException {
        dbHelper = new SleepDBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    private ContentValues createPreferencesValues(String information) {
        ContentValues values = new ContentValues();
        values.put("information", information);
        return values;
    }

    private ContentValues createSessionsValues(String date){
        ContentValues values = new ContentValues();
        values.put("date", date);
        return values;
    }

    private ContentValues createDatapointsValues(long session_id, double datapoint){
        ContentValues values = new ContentValues();
        values.put("session_id", session_id);
        values.put("datapoint", datapoint);
        return values;
    }

    public long createPreference(String information){
        ContentValues initialValues = createPreferencesValues(information);
        return db.insert("preferences", null, initialValues);
    }

    public long createSession(String date){
        ContentValues initialValues = createSessionsValues(date);
        return db.insert("sessions", null, initialValues);
    }

    public long createDatapoint(Long session_id, double datapoint){
        ContentValues initialValues = createDatapointsValues(session_id, datapoint);
        return db.insert("datapoints", null, initialValues);
    }

    public boolean updatePreference(long p_id, String information){
        ContentValues updateValues = createPreferencesValues(information);
        return db.update("preferences", updateValues, "p_id =" + p_id, null) > 0;
    }
}
