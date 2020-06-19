package com.example.sahranalbum;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {

    public static void Save_name(Context context,String name){
        SharedPreferences pref = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("name", name);
        editor.commit();
    }

    public static String Get_name(Context context){
        SharedPreferences pref = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        return pref.getString("name","");
    }

    public static void Save_nameee(Context context,String name){
        SharedPreferences pref = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("nameee", name);
        editor.commit();
    }

    public static String Get_nameee(Context context){
        SharedPreferences pref = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        return pref.getString("nameee","");
    }

}
