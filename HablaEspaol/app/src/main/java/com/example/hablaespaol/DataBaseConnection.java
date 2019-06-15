package com.example.hablaespaol;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;

public class DataBaseConnection extends SQLiteOpenHelper {

    public static final String namedb="HablaEsp.db";
    public static final int version=1;

    public DataBaseConnection(Context context) {
        super(context, namedb, null, version);
    }





    @Override
    public void onCreate(SQLiteDatabase db) {

        //create table for categories
        db.execSQL("create table if not exists categories(id INTEGER PRIMARY KEY,category ,NO_image)");

        //create table for statments
          db.execSQL("create table if not exists statments(id INTEGER PRIMARY KEY,No_category,statment)");

        //create table for descriptions
        db.execSQL("create table if not exists descriptions(id INTEGER PRIMARY KEY,No_category,No_statments,description)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists categories");
        db.execSQL("drop table if exists statments");
        db.execSQL("drop table if exists descriptions");


    }




    public void InsertValueCategory(String category,int NO_image){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();


        contentValues.put("category",category);
        contentValues.put("NO_image",NO_image);
        db.insert("categories",null,contentValues);
    }

    public void InsertValueStatments(int No_category,String statment){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        // if(viewdata(email,password)==false)

        contentValues.put("statment",statment);
        contentValues.put("No_category",No_category);

        db.insert("statments",null,contentValues);
    }


    public void InsertValueDescriptions(int No_category,int No_statments ,String Description){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        // if(viewdata(email,password)==false)
        contentValues.put("No_category",No_category);
        contentValues.put("No_statments",No_statments);
        contentValues.put("Description",Description);


        Log.d("Connection", "SetData");

        long r=db.insert("Descriptions",null,contentValues);

        Log.d("Connection", "SetData="+r);

    }


    public Cursor ViewData(){

        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor;

        cursor= db.rawQuery("select * from categories",null);
        return cursor;



    }



}
