package com.didasko.eduardo.tender;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MinhasReceitas extends AppCompatActivity {

    Button botaoBack;
    Button botaoBack1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.minhas_receitas);




        botaoBack = (Button) findViewById(R.id.botaoBack);
        botaoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MinhasReceitas.this, TelaPerfil.class);
                startActivity(intent1);
                finish();
            }
        });

        botaoBack1 = (Button) findViewById(R.id.botaoBack1);
        botaoBack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MinhasReceitas.this, MainActivity.class);
                startActivity(intent1);
                finish();
            }
        });

    }
}
