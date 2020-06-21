package com.example.akshaybhandari.blooddonation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class db extends SQLiteOpenHelper {
    public db(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "blooddetails.db", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE DONOR (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT,BLOOD TEXT,AGE INTEGER,MOBNO TEXT,DAYS TEXT,THREEMONTHS INTEGER);");
        sqLiteDatabase.execSQL("CREATE TABLE CASES (HOSPID TEXT PRIMARY KEY, PATIENTNAME TEXT,MOBNO TEXT,AGE INTEGER,TREATMENT TEXT,BLOOD INTEGER,PLATELET INTEGER, BLOODGROUP TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //sqLiteDatabase.execSQL("DROP TABLE IF EXISTS STUDENTS;");
        //sqLiteDatabase.execSQL("DROP TABLE IF EXISTS MESSAGES;");
        onCreate(sqLiteDatabase);
    }
    public void insertDonor(String name,String bloodgroup,int age,String mobno,String days,int three)
    {
        ContentValues cv=new ContentValues();

        cv.put("NAME",name);
        cv.put("BLOOD",bloodgroup);
        cv.put("AGE",age);
        cv.put("MOBNO",mobno);
        cv.put("DAYS",days);
        cv.put("THREEMONTHS",three);
        this.getWritableDatabase().insertOrThrow("DONOR","",cv);
    }
    public void insertCase(String hospid,String name,String mobno,int age,String treatment,int bno,int pno,String bloodgroup)
    {
        ContentValues cv=new ContentValues();
        cv.put("HOSPID",hospid);
        cv.put("PATIENTNAME",name);
        cv.put("MOBNO",mobno);
        cv.put("AGE",age);
        cv.put("TREATMENT",treatment);
        cv.put("BLOOD",bno);
        cv.put("PLATELET",pno);
        cv.put("BLOODGROUP",bloodgroup);
        this.getWritableDatabase().insertOrThrow("CASES","",cv);
    }
    public Cursor getDonorsBlood(String bd) {
        SQLiteDatabase sql = this.getReadableDatabase();
        Cursor cr = sql.rawQuery("SELECT ID,NAME,AGE,MOBNO FROM DONOR WHERE BLOOD='"+bd+"'", null);
        return cr;
    }



    public Cursor getAllDonors()
    {
        SQLiteDatabase sql =this.getReadableDatabase();
        Cursor cr=sql.rawQuery("SELECT * FROM DONOR",null);
        return cr;
    }
    public Cursor getAllCases()
    {
        SQLiteDatabase sql =this.getReadableDatabase();
        Cursor cr=sql.rawQuery("SELECT * FROM CASES",null);
        return cr;
    }
    public void giveBloodDonor(String hospid,int bno)
    {
        SQLiteDatabase sql =this.getReadableDatabase();
        Cursor cr=sql.rawQuery("SELECT * FROM CASES WHERE HOSPID='"+hospid+"'",null);
        int reqb;
        cr.moveToNext();
        reqb=cr.getInt(5);
        int newb=reqb-bno;
        sql.close();
        ContentValues cv=new ContentValues();
        cv.put("BLOOD",newb);
        SQLiteDatabase sql1=this.getWritableDatabase();
        this.getWritableDatabase().update("CASES",cv,"HOSPID='"+hospid+"'",null);
        sql1.close();

    }
    public void givePlateletDonor(String hospid,int pno)
    {
        SQLiteDatabase sql =this.getReadableDatabase();
        Cursor cr=sql.rawQuery("SELECT * FROM CASES WHERE HOSPID='"+hospid+"'",null);
        int reqp;
        cr.moveToNext();
        reqp=cr.getInt(6);
        int newp=reqp-pno;
        sql.close();
        ContentValues cv=new ContentValues();
        cv.put("PLATELET",newp);
        SQLiteDatabase sql1=this.getWritableDatabase();
        this.getWritableDatabase().update("CASES",cv,"HOSPID='"+hospid+"'",null);
        sql1.close();
    }


}
