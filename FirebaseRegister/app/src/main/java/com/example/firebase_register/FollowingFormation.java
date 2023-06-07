package com.example.firebase_register;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FollowingFormation extends AppCompatActivity {
     String nameUser, emailUser, usernameUser, formationNameUser, formationtimeUser;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_following_formation);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bottom_home:
                    return true;
                case R.id.bottom_cours:
                    showUserData();
                    Intent intent = new Intent(getApplicationContext(), CoursActivity.class);
                    intent.putExtra("name", nameUser);
                    intent.putExtra("email", emailUser);
                    intent.putExtra("username", usernameUser);
                    intent.putExtra("formationName", formationNameUser);
                    intent.putExtra("formationtime", formationtimeUser);
                    startActivity(intent);
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