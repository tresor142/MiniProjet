package com.example.miniprojet.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.miniprojet.R;

public class Menu_principal extends AppCompatActivity {

    private Button souscription;
    private Button paiement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        souscription = (Button) findViewById(R.id.souscription);
        paiement = (Button) findViewById(R.id.paiement);

        souscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent accueilIntent = new Intent(Menu_principal.this, ServuceActivity.class);
                startActivity(accueilIntent);
            }
        });


        paiement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent accueilIntent = new Intent(Menu_principal.this, ServuceActivity.class);
                startActivity(accueilIntent);
            }
        });

    }
}