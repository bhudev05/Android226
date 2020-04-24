package com.example.examination_mngmt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ExamDatabase extends SQLiteOpenHelper {
    private static String dbname = "mydatabase";
    private static int version = 1;
    Context ct;

    public ExamDatabase(Context ct) {
        super(ct, dbname, null, version);
        this.ct=ct;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Toast.makeText(ct,"IN Increate",Toast.LENGTH_SHORT).show();

    String s = "create table info( name text, registration integer, room text, subject text, date text )";
    db.execSQL(s);

    }

    public void insertValues(String s1, long l, String s2, String s3, String s4)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("name",s1);
        cv.put("registration",l);
        cv.put("room",s2);
        cv.put("subject",s3);
        cv.put("date",s4);

        db.insert("info",null,cv);
        Toast.makeText(ct,"Data Saved Successfully",Toast.LENGTH_SHORT).show();

    }

    public ArrayList<String> showValues()
    {
        Toast.makeText(ct,"Inside show values",Toast.LENGTH_SHORT).show();
        SQLiteDatabase db = getReadableDatabase();
        String s = "select * from info";
        Cursor cr = db.rawQuery(s,null);

        ArrayList<String> al = new ArrayList<>();

        while(cr.moveToNext()){
            String s1 = cr.getString(0);
            long l = cr.getLong(1);
            String s2 = cr.getString(2);
            String s3 = cr.getString(3);
            String s4 = cr.getString(4);

            String s6 = "Name is: "+ s1 + "\nRegistration_No. is: "+ l + "\nRoom_No is: " + s2 + "\nSubject is :"+ s3 + "\nDate :" + s4;
            al.add(s6);
        }
        return al;
    }

    public  void  doUpdate(String s1, long l, String s2, String s3, String s4)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("registration",l);
        cv.put("room",s2);
        cv.put("subject",s3);
        cv.put("date",s4);

        String where = "name =?";
        String [] ss = {s1};

        db.update("info",cv,where,ss);
        Toast.makeText(ct,"Updation Completed",Toast.LENGTH_SHORT).show();
    }

    public void doDelete(String s)
    {
        SQLiteDatabase db = getWritableDatabase();
        String where = "name =?";

        String[] ss = {s};
        db.delete("info",where,ss);

        Toast.makeText(ct,"Deletion Completed",Toast.LENGTH_SHORT).show();
    }


    public ArrayList<String> doSearch(String name)
    {
        SQLiteDatabase db = getReadableDatabase();

        String s = "select * from info where name = ? ";

        String[] ss = {name};
        Cursor cr = db.rawQuery(s,ss);

        ArrayList<String> al = new ArrayList<>();

        while(cr.moveToNext())
        {

            String s1 = cr.getString(0);
            long l = cr.getLong(1);
            String s2 = cr.getString(2);
            String s3 = cr.getString(3);
            String s4 = cr.getString(4);

            String s6 = "Name is: " +s1 + "\nRegistration_No: " + l + "\nRoom No: " + s2+ "\nSubject is:"+ s3 + "Date :"+s4;
            al.add(s6);

        }
        return al;

    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
