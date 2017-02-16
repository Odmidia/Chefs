package com.didasko.eduardo.tender;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Chat extends AppCompatActivity {

    Button botaoHome;
    Button irReceita;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);


        botaoHome = (Button)findViewById(R.id.botaoHome);
        botaoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chat.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        irReceita = (Button)findViewById(R.id.irReceita);
        irReceita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chat.this, receita.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
