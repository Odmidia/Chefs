package com.didasko.eduardo.tender;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ReceitasCurtidas extends AppCompatActivity {

    Button rectHome;
    Button minhaRect;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receitas_curtidas);

        rectHome = (Button)findViewById(R.id.rectHome);
        rectHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReceitasCurtidas.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        minhaRect = (Button)findViewById(R.id.minhaRect);
        minhaRect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ReceitasCurtidas.this, MinhasReceitas.class);
                startActivity(intent1);
                finish();
            }
        });

    }
}
