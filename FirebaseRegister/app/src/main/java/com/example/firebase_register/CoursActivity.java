package com.example.firebase_register;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.firebase_register.tableau_de_bord.InformatiqueActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CoursActivity extends AppCompatActivity {
    String nameUser2, emailUser2, usernameUser2, formationNameUser2, formationtimeUser2;
    CardView informatique;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cours);

        informatique = findViewById(R.id.informatiqueCard);
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
                case R.id.bottom_cours:
                    return true;
            }
            return false;
        });
        informatique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoursActivity.this, InformatiqueActivity.class);
                startActivity(intent);
            }
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