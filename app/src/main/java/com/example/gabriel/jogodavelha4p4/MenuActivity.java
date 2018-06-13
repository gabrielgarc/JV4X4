package com.example.gabriel.jogodavelha4p4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    Button pvp;
    Button pvc;
    Button sair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        init();
    }

    private void init(){
        pvp = findViewById(R.id.btn_pvp);
        pvc = findViewById(R.id.btn_pvc);
        sair = findViewById(R.id.btn_sair);

        pvp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, PvPActivity.class));
            }
        });

        pvc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, PvCActivity.class));
            }
        });

        sair.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }
}
