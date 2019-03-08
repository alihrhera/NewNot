package com.example.alihrhera.newnot;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MyDataBas {
    final  private String  DATABASE_NAME="MyNotes.db";
    final  private int DBversion= 2; // new
    private DatabaseHelper database;
    private SQLiteDatabase db;
    private String  TABLENAME="MyNots";

    public MyDataBas(Context context){
        database=new DatabaseHelper(context);
        db=database.getReadableDatabase();
      //  db.execSQL("delete from "+ TABLENAME);

    }


    public boolean Insert(String not,int color){
        ContentValues conv = new ContentValues();
        conv.put("Content", not);
        conv.put("color", color);
        long isdone=db.insert(TABLENAME, null, conv);
        return isdone>-1;
    }

    public boolean UpdateRow(){
        ContentValues conv = new ContentValues();
        conv.put("Content","update Test");
        long update=db.update(TABLENAME, conv, "ID="+3, null);
        return update!=-1;
    }


    public boolean deleterow() {
        long deleted=db.delete(TABLENAME, "ID=" + 4, null);
        return deleted>0;
    }


    public ArrayList<MyNot> AllData(){
        ArrayList<MyNot>  reternudlist=new ArrayList();
        Cursor crs = db.rawQuery("SELECT * FROM "+TABLENAME, null);
        crs.moveToFirst();
        while (!crs.isAfterLast()) {
            MyNot not=new MyNot();
            not.setContent(crs.getString(crs.getColumnIndex("Content")));
            not.setColor(crs.getInt(crs.getColumnIndex("color")));
            not.setId(crs.getInt(crs.getColumnIndex("ID")));
            reternudlist.add(not);
            crs.moveToNext();
        }
        crs.close();
        return reternudlist;
    }







    class DatabaseHelper extends SQLiteOpenHelper  {
        public DatabaseHelper(Context context){
            super(context,DATABASE_NAME,null,DBversion);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL("create table IF NOT EXISTS "+TABLENAME
            +"(ID INTEGER PRIMARY KEY AUTOINCREMENT,Content Text)");

        }

        @Override
        public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL("ALTER TABLE MyNots ADD column color INTEGER");
        }
    }
}
