package com.example.tugas_sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText EJudul, Egenre;
    private String SJudul, Sgenre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        EJudul = (EditText) findViewById(R.id.create_judul);
        Egenre = (EditText) findViewById(R.id.create_genre);
        Button btnCreate = (Button)
                findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SJudul = String.valueOf(EJudul.getText());
                Sgenre = String.valueOf(Egenre.getText());
                if (SJudul.equals("")){
                    EJudul.requestFocus();
                    Toast.makeText(MainCreate.this, "Insert Movie Judul",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Sgenre.equals("")) {
                    Egenre.requestFocus();
                    Toast.makeText(MainCreate.this, "Insert Movie Genre",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    EJudul.setText("");
                    Egenre.setText("");
                    Toast.makeText(MainCreate.this, "Data has been added",
                            Toast.LENGTH_SHORT).show();
                    db.CreateMovieList(new MovieList(null, SJudul,
                            Sgenre));
                    Intent a = new Intent(MainCreate.this,
                            MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}
