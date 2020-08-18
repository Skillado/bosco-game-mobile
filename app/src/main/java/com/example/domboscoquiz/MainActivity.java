package com.example.domboscoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //avatares
    Button bCredits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //associar
        bCredits = (Button)findViewById(R.id.bCredits);

        //escuta eventos
        bCredits.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent novaTela = new Intent(this, telaCreditos.class);
        startActivityForResult(novaTela, 1);
    }
}