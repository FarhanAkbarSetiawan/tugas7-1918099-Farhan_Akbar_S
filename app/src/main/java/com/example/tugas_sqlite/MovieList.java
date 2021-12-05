package com.example.tugas_sqlite;

public class MovieList {
    private String _id, _Judul, _genre;
    public MovieList(String id, String Judul, String genre ) {
        this._id = id;
        this._Judul = Judul;
        this._genre = genre;
    }
    public MovieList() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_Judul() {
        return _Judul;
    }
    public void set_Judul(String _Judul) {
        this._Judul = _Judul;
    }
    public String get_genre() {
        return _genre;
    }
    public void set_genre(String _genre) {
        this._genre = _genre;
    }
}
