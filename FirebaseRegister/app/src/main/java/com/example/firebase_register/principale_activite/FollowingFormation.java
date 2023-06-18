package com.example.firebase_register.principale_activite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.firebase_register.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FollowingFormation extends AppCompatActivity {
     String nameUser, emailUser, usernameUser, formationNameUser, formationtimeUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_following_formation);

        Button buttonFollow = findViewById(R.id.buttonFollowing);
        buttonFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FollowingFormation.this, "Suivie de la Formation", Toast.LENGTH_SHORT).show();
            }
        });

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
                case R.id.bottom_parametre:
                    showUserData();
                    Intent intent3 = new Intent(getApplicationContext(), ParametresActivity.class);
                    intent3.putExtra("name", nameUser);
                    intent3.putExtra("email", emailUser);
                    intent3.putExtra("username", usernameUser);
                    intent3.putExtra("formationName", formationNameUser);
                    intent3.putExtra("formationtime", formationtimeUser);
                    startActivity(intent3);
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