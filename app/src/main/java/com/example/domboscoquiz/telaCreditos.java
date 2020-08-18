package com.example.domboscoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class telaCreditos extends AppCompatActivity implements View.OnClickListener{

    //avatares
    Button bVolta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_creditos);

        //associar
        bVolta = (Button)findViewById(R.id.bVolta);

        //escuta eventos
        bVolta.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}