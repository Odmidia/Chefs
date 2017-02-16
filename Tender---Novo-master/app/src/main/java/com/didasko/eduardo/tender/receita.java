package com.didasko.eduardo.tender;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class receita extends AppCompatActivity {

    Button irChat;
    Button homeReceita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receitas);



        irChat = (Button)findViewById(R.id.irChat);
        irChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(receita.this, Chat.class);
                startActivity(intent);
                finish();
            }
        });

        homeReceita = (Button)findViewById(R.id.homeReceita);
        homeReceita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(receita.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
