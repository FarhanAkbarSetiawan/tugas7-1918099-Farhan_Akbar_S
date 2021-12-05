package com.example.tugas_sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<MovieList> ListMovieList = new ArrayList<MovieList>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListMovieList
        );
        mListView = (ListView) findViewById(R.id.list_Movie);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListMovieList.clear();
        List<MovieList> Movielist = db.ReadmovieList();
        for (MovieList Movie : Movielist) {
            MovieList daftar = new MovieList();
            daftar.set_id(Movie.get_id());
            daftar.set_Judul(Movie.get_Judul());
            daftar.set_genre(Movie.get_genre());
            ListMovieList.add(daftar);
            if ((ListMovieList.isEmpty()))
                Toast.makeText(MainRead.this, "Data not found",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        MovieList detailMovie = (MovieList) o;
        String Sid = detailMovie.get_id();
        String SJudul = detailMovie.get_Judul();
        String Sgenre = detailMovie.get_genre();
        Intent goUpdel = new Intent(MainRead.this,
                MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("IJudul", SJudul);
        goUpdel.putExtra("Igenre", Sgenre);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListMovieList.clear();
        mListView.setAdapter(adapter_off);
        List<MovieList> Movielist = db.ReadmovieList();
        for (MovieList Movie : Movielist) {
            MovieList daftar = new MovieList();
            daftar.set_id(Movie.get_id());
            daftar.set_Judul(Movie.get_Judul());
            daftar.set_genre(Movie.get_genre());
            ListMovieList.add(daftar);
            if ((ListMovieList.isEmpty()))
                Toast.makeText(MainRead.this, "Data Not Found",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
