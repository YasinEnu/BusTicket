package com.yasin.hosain.busticket;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by YASIN on 07,May,2019
 * Email: yasinenubd5@gmail.com
 */

public class AppData {
    private static String TAG = AppData.class.getSimpleName();
    private static final String PREF_NAME = "Bus ticket";
    private static final String KEY_FROM_DATA = "fromData";
    private static final String KEY_TO_DATA = "toData";
    private static final String KEY_FROM_ID = "fromID";
    private static final String KEY_TO_ID = "toID";
    private static final String KEY_JOURNEY_DATE = "journeyDate";

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;


    public AppData(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public String getFromData() {
        return pref.getString(KEY_FROM_DATA, "null");
    }

    public void setFromData(String fromData) {

        editor.putString(KEY_FROM_DATA, fromData);
        editor.commit();
    }
    public String getToData() {
        return pref.getString(KEY_TO_DATA, "null");
    }

    public void setToData(String toData) {

        editor.putString(KEY_TO_DATA, toData);
        editor.commit();
    }

    public String getFromID() {
        return pref.getString(KEY_FROM_ID, "null");
    }

    public void setFromID(String fromID) {

        editor.putString(KEY_FROM_ID, fromID);
        editor.commit();
    }
    public String getToID() {
        return pref.getString(KEY_TO_ID, "null");
    }

    public void setToID(String toID) {

        editor.putString(KEY_TO_ID, toID);
        editor.commit();
    }
    public String getJourneyDate() {
        return pref.getString(KEY_JOURNEY_DATE, "null");
    }

    public void setJourneyDate(String journeyDate) {
        editor.putString(KEY_JOURNEY_DATE, journeyDate);
        editor.commit();
    }
}
