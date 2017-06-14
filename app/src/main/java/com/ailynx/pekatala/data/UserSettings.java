package com.ailynx.pekatala.data;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Indra Tirta Nugraha on 08/05/2017.
 */

public class UserSettings {
    public static String SERVER_URL = "http://pekatala.hol.es/pekatala/";
    private static UserSettings userSettings;
    public Context context;
    static String KEY = "userLogin";

    public UserSettings(Context context){
        this.context = context;
    }

    public synchronized static UserSettings newInstance(Context context){
        if (userSettings == null){
            userSettings = new UserSettings(context);
        }
        return userSettings;
    }

    public void save(){
        SharedPreferences myPrefContainer = context.getSharedPreferences(KEY, Activity.MODE_PRIVATE);
        SharedPreferences.Editor myPrefEditor = myPrefContainer.edit();
        try {
            myPrefEditor.putString("username", UserData.USERNAME);
            myPrefEditor.putString("nama", UserData.NAMA);
            myPrefEditor.putInt("firstLogin", UserData.firstLogin);
            myPrefEditor.apply();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean isLoggedIn(){
        SharedPreferences myPref = context.getSharedPreferences(KEY, Activity.MODE_PRIVATE);
        boolean status;
        if ((myPref!=null) && (myPref.getString("username", null)!=null)){
            status = true;
            UserData.USERNAME = myPref.getString("username", null);
            UserData.NAMA = myPref.getString("nama", null);
            UserData.firstLogin = myPref.getInt("firstLogin", 0);
        } else {
            status = false;
        }
        return status;
    }

    public void remove(){
        SharedPreferences myPref = context.getSharedPreferences(KEY, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = myPref.edit();
        editor.clear();
        editor.apply();
    }
}
