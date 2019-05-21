/*
 * NIM : 10116158
 * NAMA : ALDY FERDIAN ADAM
 * KELAS : IF-4
 * TANGGAL PEMBUATAN : 21/5/2019
 */

package uts.aldy.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;

    static final String DATABASE_NAME = "biodatabeno.db";

    public static final String TABLE_NAME = "friends";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NIM = "nim";
    public static final String COLUMN_NAMA = "nama";
    public static final String COLUMN_KELAS = "kelas";
    public static final String COLUMN_TELP = "telp";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_SOCMED = "socmed";

    public DbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_MOVIE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY autoincrement, " +
                COLUMN_NIM + " TEXT  NOT NULL, " +
                COLUMN_NAMA + " TEXT NOT NULL," +
                COLUMN_KELAS + " TEXT NOT NULL," +
                COLUMN_TELP + " TEXT NOT NULL," +
                COLUMN_EMAIL + " TEXT NOT NULL," +
                COLUMN_SOCMED + " TEXT NOT NULL" +
                " )";

        db.execSQL(SQL_CREATE_MOVIE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public ArrayList<HashMap<String, String>> getAllData() {
        ArrayList<HashMap<String, String>> wordList;
        wordList = new ArrayList<HashMap<String, String>>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put(COLUMN_ID, cursor.getString(0));
                map.put(COLUMN_NIM, cursor.getString(1));
                map.put(COLUMN_NAMA, cursor.getString(2));
                map.put(COLUMN_KELAS, cursor.getString(3));
                map.put(COLUMN_TELP, cursor.getString(4));
                map.put(COLUMN_EMAIL, cursor.getString(5));
                map.put(COLUMN_SOCMED, cursor.getString(6));
                wordList.add(map);
            } while (cursor.moveToNext());
        }

        Log.e("select sqlite ", "" + wordList);

        database.close();
        return wordList;
    }

    public void insert(String nim, String nama, String kelas, String telp, String email, String socmed) {
        SQLiteDatabase database = this.getWritableDatabase();
        String queryValues = "INSERT INTO " + TABLE_NAME + " (nim, nama, kelas, telp, email, socmed) " +
                "VALUES ('" + nim + "', '" + nama + "', '" + kelas + "', '" + telp + "', '" + email + "', '" + socmed + "')";

        Log.e("insert sqlite ", "" + queryValues);
        database.execSQL(queryValues);
        database.close();
    }

    public void update(int id, String nim, String nama, String kelas, String telp, String email, String socmed) {
        SQLiteDatabase database = this.getWritableDatabase();

        String updateQuery = "UPDATE " + TABLE_NAME + " SET "
                + COLUMN_NIM + "='" + nim + "', "
                + COLUMN_NAMA + "='" + nama + "',"
                + COLUMN_KELAS + "='" + kelas + "',"
                + COLUMN_TELP + "='" + telp + "',"
                + COLUMN_EMAIL + "='" + email + "',"
                + COLUMN_SOCMED + "='" + socmed + "'"
                + " WHERE " + COLUMN_ID + "=" + "'" + id + "'";
        Log.e("update sqlite ", updateQuery);
        database.execSQL(updateQuery);
        database.close();
    }

    public void delete(int id) {
        SQLiteDatabase database = this.getWritableDatabase();

        String updateQuery = "DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + "=" + "'" + id + "'";
        Log.e("update sqlite ", updateQuery);
        database.execSQL(updateQuery);
        database.close();
    }
}
