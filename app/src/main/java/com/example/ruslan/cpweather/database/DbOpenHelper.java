package com.example.ruslan.cpweather.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.version;

/**
 * Created by Ruslan on 19.05.2017.
 */

public class DbOpenHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "weather_db";
    private static final int VERSION = 1;

    public DbOpenHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        CityContract.createTable(db);
        WeatherContract.createTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
