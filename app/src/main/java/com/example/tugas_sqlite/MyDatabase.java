package com.example.tugas_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_1918099";
    private static final String tb_Movielist = "tb_Movielist";
    private static final String tb_Movielist_id = "id";
    private static final String tb_Movielist_Judul = "Judul";
    private static final String tb_Movielist_genre = "genre";
    private static final String CREATE_TABLE_MOVIELIST = "CREATE TABLE " +
            tb_Movielist +"("
            + tb_Movielist_id + " INTEGER PRIMARY KEY ,"
            + tb_Movielist_Judul + " TEXT ,"
            + tb_Movielist_genre + " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MOVIELIST);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void CreateMovieList (MovieList data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_Movielist_id, data.get_id());
        values.put(tb_Movielist_Judul, data.get_Judul());
        values.put(tb_Movielist_genre, data.get_genre());
        db.insert(tb_Movielist, null, values);
        db.close();
    }
    public List<MovieList> ReadmovieList() {
        List<MovieList> listMovie = new ArrayList<MovieList>();
        String selectQuery = "SELECT * FROM " + tb_Movielist;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                MovieList data = new MovieList();
                data.set_id(cursor.getString(0));
                data.set_Judul(cursor.getString(1));
                data.set_genre(cursor.getString(2));
                listMovie.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listMovie;
    }
    public int UpdateGameList (MovieList data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_Movielist_Judul, data.get_Judul());
        values.put(tb_Movielist_genre, data.get_genre());
        return db.update(tb_Movielist, values, tb_Movielist_id +
                        " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeleteGameList(MovieList data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_Movielist,tb_Movielist_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}
