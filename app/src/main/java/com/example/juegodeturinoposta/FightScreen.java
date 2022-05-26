package com.example.juegodeturinoposta;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.juegodeturinoposta.model.DataBaseManager;

public class FightScreen extends AppCompatActivity {

    TextView textViewNameOwn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fight_screen);

        textViewNameOwn = findViewById(R.id.textViewNameOwn);
        DataBaseManager dataBaseManager = new DataBaseManager(this);
        dataBaseManager.open();

        Cursor cursor = dataBaseManager.fetch();
        cursor.moveToFirst();

        textViewNameOwn.setText(cursor.getString(0));




    }
}
