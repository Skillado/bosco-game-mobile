package com.example.domboscoquizmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class telaInicio extends AppCompatActivity {

    Button btnComecar;
    Button btnCreditos;
    ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicio);

        ImageView backButton = (ImageView)findViewById(R.id.backBtn);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (telaInicio.this, MainActivity.class);
                finish();
            }
        });

        btnComecar = (Button)findViewById(R.id.btnComecar);

        btnComecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (telaInicio.this, telaTema.class);
                startActivity(intent);
            }
        });

        btnCreditos = (Button)findViewById(R.id.btnCreditos);

        btnCreditos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (telaInicio.this, telaCreditos.class);
                startActivity(intent);
            }
        });
    }
}