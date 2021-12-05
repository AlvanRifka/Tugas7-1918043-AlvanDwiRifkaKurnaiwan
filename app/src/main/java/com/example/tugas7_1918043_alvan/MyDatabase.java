package com.example.tugas7_1918043_alvan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_tokokacamata";
    private static final String tb_kacamata = "tb_kacamata";
    private static final String tb_kacamata_id = "id";
    private static final String tb_kacamata_nama = "nama";
    private static final String tb_kacamata_jenis = "jenis";
    private static final String CREATE_TABLE_KACAMATA = "CREATE TABLE " + tb_kacamata +"("
            + tb_kacamata_id + " INTEGER PRIMARY KEY ,"
            + tb_kacamata_nama + " TEXT ,"
            + tb_kacamata_jenis + " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_KACAMATA);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public void CreateKacamata(Kacamata data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_kacamata_id, data.get_id());
        values.put(tb_kacamata_nama, data.get_nama());
        values.put(tb_kacamata_jenis, data.get_jenis());
        db.insert(tb_kacamata, null, values);
        db.close();
    }
    public List<Kacamata> ReadKacamata() {
        List<Kacamata> listKcm = new ArrayList<Kacamata>();
        String selectQuery = "SELECT * FROM " + tb_kacamata;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Kacamata data = new Kacamata();
                data.set_id(cursor.getString(0));
                data.set_nama(cursor.getString(1));
                data.set_jenis(cursor.getString(2));
                listKcm.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listKcm;
    }
    public int UpdateKacamata (Kacamata data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_kacamata_nama, data.get_nama());
        values.put(tb_kacamata_jenis, data.get_jenis());
        return db.update(tb_kacamata, values, tb_kacamata_id + " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeleteKacamata(Kacamata data){ SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_kacamata,tb_kacamata_id+ " = ?", new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}

