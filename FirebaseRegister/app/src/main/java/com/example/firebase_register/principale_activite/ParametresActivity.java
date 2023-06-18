package com.example.firebase_register.principale_activite;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.firebase_register.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ParametresActivity extends AppCompatActivity {
    String nameUser, emailUser, usernameUser, formationNameUser, formationtimeUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);

        showUserData();

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) CardView Logout = findViewById(R.id.logoutCard);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ParametresActivity.this, "Vous êtes déconnecté", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
                finish();
            }
        });
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) CardView History = findViewById(R.id.historyCard);
        History.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HistoriquesActivity.class);
                intent.putExtra("name", nameUser);
                intent.putExtra("email", emailUser);
                intent.putExtra("username", usernameUser);
                intent.putExtra("formationName", formationNameUser);
                intent.putExtra("formationtime", formationtimeUser);
                startActivity(intent);
            }
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_parametre);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bottom_home:
                    showUserData();
                    Intent intent = new Intent(getApplicationContext(), FollowingFormation.class);
                    intent.putExtra("name", nameUser);
                    intent.putExtra("email", emailUser);
                    intent.putExtra("username", usernameUser);
                    intent.putExtra("formationName", formationNameUser);
                    intent.putExtra("formationtime", formationtimeUser);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_cours:
                    showUserData();
                    Intent intent_ = new Intent(getApplicationContext(), CoursActivity.class);
                    intent_.putExtra("name", nameUser);
                    intent_.putExtra("email", emailUser);
                    intent_.putExtra("username", usernameUser);
                    intent_.putExtra("formationName", formationNameUser);
                    intent_.putExtra("formationtime", formationtimeUser);
                    startActivity(intent_);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_profil:
                    showUserData();
                    Intent intent2 = new Intent(getApplicationContext(), ProfileActivity.class);
                    intent2.putExtra("name", nameUser);
                    intent2.putExtra("email", emailUser);
                    intent2.putExtra("username", usernameUser);
                    intent2.putExtra("formationName", formationNameUser);
                    intent2.putExtra("formationtime", formationtimeUser);
                    startActivity(intent2);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_parametre:
                    return true;
            }
            return false;
        });
    }
    private void showUserData(){

        Intent intent = getIntent();

        nameUser = intent.getStringExtra("name");
        emailUser = intent.getStringExtra("email");
        usernameUser = intent.getStringExtra("username");
        formationNameUser = intent.getStringExtra("formationName");
        formationtimeUser = intent.getStringExtra("formationtime");
    }
}