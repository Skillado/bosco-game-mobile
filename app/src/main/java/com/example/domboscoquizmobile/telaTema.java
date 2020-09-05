package com.example.domboscoquizmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class telaTema extends AppCompatActivity {

    ImageView backButton;
    Button btnDomBosco;
    Button btnNossaSenhora;
    Button btnEssj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_tema);

        ImageView backButton = (ImageView)findViewById(R.id.backBtn);
        Button btnDomBosco = (Button)findViewById(R.id.btnDomBosco);
        Button btnNossaSenhora = (Button)findViewById(R.id.btnNossaSenhora);
        Button btnEssj = (Button)findViewById(R.id.btnEssj);

        btnDomBosco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(telaTema.this, telaQuiz.class);
                startActivity(intent);
            }
        });

        btnNossaSenhora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(telaTema.this, telaQuiz.class);
                startActivity(intent);
            }
        });

        btnEssj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(telaTema.this, telaQuiz.class);
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (telaTema.this, telaInicio.class);
                finish();
            }
        });
    }
}