package com.example.firebase_register.principale_activite;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.firebase_register.R;

public class HomePage extends AppCompatActivity {
    private Button btn_login, btn_sigup;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        btn_login = (Button) findViewById(R.id.btn_login);
        btn_sigup = (Button) findViewById(R.id.btn_sigup);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, ConnexionActivity.class);
                startActivity(intent);
            }
        });

        btn_sigup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, InscriptionActivity.class);
                startActivity(intent);
            }
        });
    }
}