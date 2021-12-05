package com.example.tugas_sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, SJudul, Sgenre;
    private EditText EJudul, Egenre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        SJudul = i.getStringExtra("Inama");
        Sgenre = i.getStringExtra("Ikelas");
        EJudul = (EditText) findViewById(R.id.updel_Judul);
        Egenre = (EditText) findViewById(R.id.updel_genre);
        EJudul.setText(SJudul);
        Egenre.setText(Sgenre);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SJudul = String.valueOf(EJudul.getText());
                Sgenre  = String.valueOf(Egenre.getText());
                if (SJudul.equals("")){
                    EJudul.requestFocus();
                    Toast.makeText(MainUpdel.this, "Input Movie Judul",
                            Toast.LENGTH_SHORT).show();
                } else if (Sgenre.equals("")){
                    Egenre.requestFocus();
                    Toast.makeText(MainUpdel.this, "Input Movie Genre",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateGameList(new MovieList(Sid, SJudul,
                            Sgenre));
                    Toast.makeText(MainUpdel.this, "Data has been update",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteGameList(new MovieList(Sid, SJudul,
                        Sgenre));
                Toast.makeText(MainUpdel.this, "Data has been deleted",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
