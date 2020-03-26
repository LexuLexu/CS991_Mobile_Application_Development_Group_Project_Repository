package com.example.tutorprototype1;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class MyDBHandler extends SQLiteOpenHelper {
    //information of database
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "accounts.db";
    public static final String TABLE_ACCOUNTS = "accounts";
    public static final String COLUMN_ACCOUNTEMAIL = "accountemail";
    public static final String COLUMN_ACCOUNTPASSWORD = "accountpassword";
    //initialize the database
    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_ACCOUNTS + "(" +
                COLUMN_ACCOUNTEMAIL + " TEXT PRIMARY KEY, " +
                COLUMN_ACCOUNTPASSWORD + " TEXT " +
                ");";

        db.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACCOUNTS);
        onCreate(db);
    }

    public void addAccount (Account account) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_ACCOUNTEMAIL, account.getEmail());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_ACCOUNTS, null, values);
        db.close();
    }

    public void deleteAccount (String accountEmail) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_ACCOUNTS + " WHERE " +
                COLUMN_ACCOUNTEMAIL + "=\"" + accountEmail + "\";");
    }

    public String databaseToString() {
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_ACCOUNTS + " WHERE 1";

        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        while(!c.isAfterLast()) {
            if(c.getString(c.getColumnIndex("accountemail")) != null) {
                dbString += c.getString(c.getColumnIndex("accountemail"));
                dbString += "  -  ";
            }
            if(c.getString(c.getColumnIndex("accountpassword")) != null) {
                dbString += c.getString(c.getColumnIndex("accountpassword"));
                dbString += "\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }

}