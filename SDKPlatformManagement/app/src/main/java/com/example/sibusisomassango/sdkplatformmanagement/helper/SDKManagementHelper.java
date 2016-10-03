package com.example.sibusisomassango.sdkplatformmanagement.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.sibusisomassango.sdkplatformmanagement.utils.SDKManagerItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sibusisomassango on 2016/10/03.
 */
public class SDKManagementHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "SDKManagement.db";

    public static final String KEY_ID = "_id";
    public static final String KEY_DATE = "sdkDate";
    public static final String KEY_TITLE = "sdkTitle";

    public static final String SDK_TABLE = "tblsdkmanagementlist";

    public static final String CREATE_TABLE_SDK = "create table "+SDK_TABLE+ " ( "+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+KEY_DATE+" text ,"+KEY_TITLE+" text )";
    public SDKManagementHelper(Context context){
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SDK);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + SDK_TABLE);
        onCreate(db);
    }
    public long insertSDK(String title)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_TITLE, title);
        contentValues.put(KEY_DATE, new Date().getTime());

        return db.insert(SDK_TABLE, null, contentValues);
    }
    public List<SDKManagerItem> getSDKList(){
        List<SDKManagerItem> SDKManagerList = new ArrayList<SDKManagerItem>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor results =  db.rawQuery( "select * from "+SDK_TABLE, null );
        results.moveToFirst();

        while(results.isAfterLast() == false){
            SDKManagerList.add(new SDKManagerItem(results.getString(results.getColumnIndex(KEY_TITLE))));
            results.moveToNext();
        }

        return SDKManagerList;
    }
}
