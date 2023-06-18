package com.example.firebase_register.principale_activite;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.firebase_register.R;
import com.example.firebase_register.tableau_de_bord.EnergetiqueActivity;
import com.example.firebase_register.tableau_de_bord.GCivilActivity;
import com.example.firebase_register.tableau_de_bord.InformatiqueActivity;
import com.example.firebase_register.tableau_de_bord.MecaniqueActivity;
import com.example.firebase_register.tableau_de_bord.TelecomActivity;
import com.example.firebase_register.tableau_de_bord.TopoActivity;

public class HomeActivity extends AppCompatActivity {
    private Button btnPlus;
    private CardView informatique, mecanique, topo, telecom, GCivil, energetique;
    private String nameUser, emailUser, usernameUser, passwordUser;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        informatique = findViewById(R.id.informatiqueCard);
        mecanique = findViewById(R.id.mecaniqueCard);
        GCivil = findViewById(R.id.GCCard);
        energetique = findViewById(R.id.energetiqueCard);
        telecom = findViewById(R.id.telecomCard);
        topo = findViewById(R.id.topoCard);
        btnPlus = findViewById(R.id.btnPlus);

        Intent intent = getIntent();
        nameUser = intent.getStringExtra("name");
        emailUser = intent.getStringExtra("email");
        usernameUser = intent.getStringExtra("username");
        passwordUser = intent.getStringExtra("password");

        informatique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, InformatiqueActivity.class);
                intent.putExtra("name", nameUser);
                intent.putExtra("email", emailUser);
                intent.putExtra("username", usernameUser);
                intent.putExtra("password", passwordUser);
                startActivity(intent);
            }
        });
        mecanique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, MecaniqueActivity.class);
                intent.putExtra("name", nameUser);
                intent.putExtra("email", emailUser);
                intent.putExtra("username", usernameUser);
                intent.putExtra("password", passwordUser);
                startActivity(intent);
            }
        });
        topo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, TopoActivity.class);
                intent.putExtra("name", nameUser);
                intent.putExtra("email", emailUser);
                intent.putExtra("username", usernameUser);
                intent.putExtra("password", passwordUser);
                startActivity(intent);
            }
        });
        GCivil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, GCivilActivity.class);
                intent.putExtra("name", nameUser);
                intent.putExtra("email", emailUser);
                intent.putExtra("username", usernameUser);
                intent.putExtra("password", passwordUser);
                startActivity(intent);
            }
        });
        telecom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, TelecomActivity.class);
                intent.putExtra("name", nameUser);
                intent.putExtra("email", emailUser);
                intent.putExtra("username", usernameUser);
                intent.putExtra("password", passwordUser);
                startActivity(intent);
            }
        });
        energetique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, EnergetiqueActivity.class);
                intent.putExtra("name", nameUser);
                intent.putExtra("email", emailUser);
                intent.putExtra("username", usernameUser);
                intent.putExtra("password", passwordUser);
                startActivity(intent);
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick (View v){
            Intent intent = new Intent(HomeActivity.this, CoursActivity.class);
            intent.putExtra("name", nameUser);
            intent.putExtra("email", emailUser);
            intent.putExtra("username", usernameUser);
            intent.putExtra("password", passwordUser);
            startActivity(intent);
            }
        });
    }
}