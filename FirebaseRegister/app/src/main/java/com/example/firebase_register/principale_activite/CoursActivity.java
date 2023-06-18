package com.example.firebase_register.principale_activite;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.firebase_register.R;
import com.example.firebase_register.tableau_de_bord.ChimieActivity;
import com.example.firebase_register.tableau_de_bord.DataScienceActivity;
import com.example.firebase_register.tableau_de_bord.DroitActivity;
import com.example.firebase_register.tableau_de_bord.EconomieActivity;
import com.example.firebase_register.tableau_de_bord.EnergetiqueActivity;
import com.example.firebase_register.tableau_de_bord.GCivilActivity;
import com.example.firebase_register.tableau_de_bord.InformatiqueActivity;
import com.example.firebase_register.tableau_de_bord.MecaniqueActivity;
import com.example.firebase_register.tableau_de_bord.MicroPythonActivity;
import com.example.firebase_register.tableau_de_bord.PhysiqueActivity;
import com.example.firebase_register.tableau_de_bord.TelecomActivity;
import com.example.firebase_register.tableau_de_bord.TopoActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CoursActivity extends AppCompatActivity {
    private String nameUser2, emailUser2, usernameUser2, formationNameUser2, formationtimeUser2;
    private String nameUser, emailUser, usernameUser;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cours);

        CardView microPython = findViewById(R.id.MicroPythonCard);
        CardView physique = findViewById(R.id.physiqueCard);
        CardView chimie = findViewById(R.id.chimieCard);
        CardView dataScience = findViewById(R.id.DataScienceCard);
        CardView economie = findViewById(R.id.economieCard);
        CardView droit = findViewById(R.id.droitCard);
        CardView informatique = findViewById(R.id.informatiqueCard);
        CardView mecanique = findViewById(R.id.mecaniqueCard);
        CardView GCivil = findViewById(R.id.GCCard);
        CardView energetique = findViewById(R.id.energetiqueCard);
        CardView telecom = findViewById(R.id.telecomCard);
        CardView topo = findViewById(R.id.topoCard);

        Intent intent = getIntent();
        nameUser = intent.getStringExtra("name");
        emailUser = intent.getStringExtra("email");
        usernameUser = intent.getStringExtra("username");
//        formationName = intent.getStringExtra("formationName");
//        formationTime = intent.getStringExtra("formationtime");

        microPython.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoursActivity.this, MicroPythonActivity.class);
                intent.putExtra("name", nameUser);
                intent.putExtra("email", emailUser);
                intent.putExtra("username", usernameUser);
                startActivity(intent);
            }
        });
        physique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoursActivity.this, PhysiqueActivity.class);
                intent.putExtra("name", nameUser);
                intent.putExtra("email", emailUser);
                intent.putExtra("username", usernameUser);
                startActivity(intent);
            }
        });
        chimie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoursActivity.this, ChimieActivity.class);
                intent.putExtra("name", nameUser);
                intent.putExtra("email", emailUser);
                intent.putExtra("username", usernameUser);
                startActivity(intent);
            }
        });
        droit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoursActivity.this, DroitActivity.class);
                intent.putExtra("name", nameUser);
                intent.putExtra("email", emailUser);
                intent.putExtra("username", usernameUser);
                startActivity(intent);
            }
        });
        economie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoursActivity.this, EconomieActivity.class);
                intent.putExtra("name", nameUser);
                intent.putExtra("email", emailUser);
                intent.putExtra("username", usernameUser);
                startActivity(intent);
            }
        });
        dataScience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoursActivity.this, DataScienceActivity.class);
                intent.putExtra("name", nameUser);
                intent.putExtra("email", emailUser);
                intent.putExtra("username", usernameUser);
                startActivity(intent);
            }
        });
        informatique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoursActivity.this, InformatiqueActivity.class);
                intent.putExtra("name", nameUser);
                intent.putExtra("email", emailUser);
                intent.putExtra("username", usernameUser);
                startActivity(intent);
            }
        });
        mecanique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoursActivity.this, MecaniqueActivity.class);
                intent.putExtra("name", nameUser);
                intent.putExtra("email", emailUser);
                intent.putExtra("username", usernameUser);
                startActivity(intent);
            }
        });
        topo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoursActivity.this, TopoActivity.class);
                intent.putExtra("name", nameUser);
                intent.putExtra("email", emailUser);
                intent.putExtra("username", usernameUser);
                startActivity(intent);
            }
        });
        GCivil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoursActivity.this, GCivilActivity.class);
                intent.putExtra("name", nameUser);
                intent.putExtra("email", emailUser);
                intent.putExtra("username", usernameUser);
                startActivity(intent);
            }
        });
        telecom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoursActivity.this, TelecomActivity.class);
                intent.putExtra("name", nameUser);
                intent.putExtra("email", emailUser);
                intent.putExtra("username", usernameUser);
                startActivity(intent);
            }
        });
        energetique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoursActivity.this, EnergetiqueActivity.class);
                intent.putExtra("name", nameUser);
                intent.putExtra("email", emailUser);
                intent.putExtra("username", usernameUser);
                startActivity(intent);
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_cours);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bottom_home:
                    showUserData3();
                    Intent intent2 = new Intent(getApplicationContext(), FollowingFormation.class);
                    intent2.putExtra("name", nameUser2);
                    intent2.putExtra("email", emailUser2);
                    intent2.putExtra("username", usernameUser2);
                    intent2.putExtra("formationName", formationNameUser2);
                    intent2.putExtra("formationtime", formationtimeUser2);
                    startActivity(intent2);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_profil:
                    showUserData3();
                    Intent intent3 = new Intent(getApplicationContext(), ProfileActivity.class);
                    intent3.putExtra("name", nameUser2);
                    intent3.putExtra("email", emailUser2);
                    intent3.putExtra("username", usernameUser2);
                    intent3.putExtra("formationName", formationNameUser2);
                    intent3.putExtra("formationtime", formationtimeUser2);
                    startActivity(intent3);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_parametre:
                    showUserData3();
                    Intent intent4 = new Intent(getApplicationContext(), ParametresActivity.class);
                    intent4.putExtra("name", nameUser2);
                    intent4.putExtra("email", emailUser2);
                    intent4.putExtra("username", usernameUser2);
                    intent4.putExtra("formationName", formationNameUser2);
                    intent4.putExtra("formationtime", formationtimeUser2);
                    startActivity(intent4);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_cours:
                    return true;
            }
            return false;
        });
    }
    private void showUserData3(){

        Intent intent = getIntent();

        nameUser2 = intent.getStringExtra("name");
        emailUser2 = intent.getStringExtra("email");
        usernameUser2 = intent.getStringExtra("username");
        formationNameUser2 = intent.getStringExtra("formationName");
        formationtimeUser2 = intent.getStringExtra("formationtime");
    }
}