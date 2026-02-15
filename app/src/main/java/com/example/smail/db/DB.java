package com.example.smail.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.smail.moudle.Service;

import java.util.ArrayList;

public class DB extends SQLiteOpenHelper {
    SQLiteDatabase db;
    public static final String DB_NAME = "Services";
    public static final int DB_VERSION = 1;
    public DB(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Service.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Service.TABLE_NAME);
        onCreate(db);

    }

    public boolean insertService(String name, double price) {
        ContentValues cv = new ContentValues();
        cv.put(Service.COLUMN_NAME, name);
        cv.put(Service.COLUMN_PRICE, price);
        long result = db.insert(Service.TABLE_NAME, null, cv);
        return  result>0;
    }

    @SuppressLint("Range")
    public ArrayList<Service> getAllServices() {
        ArrayList<Service> services = new ArrayList<>();
        String query = "SELECT * FROM " + Service.TABLE_NAME;
        db = getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Service service = new Service();
                service.setId(cursor.getInt(cursor.getColumnIndex(Service.COLUMN_ID)));
                service.setName(cursor.getString(cursor.getColumnIndex(Service.COLUMN_NAME)));
                service.setPrice(cursor.getDouble(cursor.getColumnIndex(Service.COLUMN_PRICE)));
                services.add(service);

            } while (cursor.moveToNext());
        }
        cursor.close();
        return services;
    }

    public boolean deleteService(int id) {
        int result = db.delete(Service.TABLE_NAME,Service.COLUMN_ID + " = ?",new String[]{String.valueOf(id)});
        return result > 0;
    }

    public boolean updateService(int id, String name, double price) {
        ContentValues cv = new ContentValues();
        cv.put(Service.COLUMN_NAME, name);
        cv.put(Service.COLUMN_PRICE, price);
        int result = db.update(Service.TABLE_NAME, cv, Service.COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
        return result > 0 ;
    }
    public void closeDB() {
        SQLiteDatabase db = getWritableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }
}
