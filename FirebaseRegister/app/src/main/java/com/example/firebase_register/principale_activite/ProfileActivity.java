package com.example.firebase_register.principale_activite;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.firebase_register.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {
    private TextView nomformation1, profileEmail, profileUsername, tempsformation1, titleName;
    String nameUser1, emailUser1, usernameUser1, formationNameUser1, formationtimeUser1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_profil);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bottom_home:
                    showUserData2();
                    Intent intent = new Intent(getApplicationContext(), FollowingFormation.class);
                    intent.putExtra("name", nameUser1);
                    intent.putExtra("email", emailUser1);
                    intent.putExtra("username", usernameUser1);
                    intent.putExtra("formationName", formationNameUser1);
                    intent.putExtra("formationtime", formationtimeUser1);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_cours:
                    showUserData2();
                    Intent intent2 = new Intent(getApplicationContext(), CoursActivity.class);
                    intent2.putExtra("name", nameUser1);
                    intent2.putExtra("email", emailUser1);
                    intent2.putExtra("username", usernameUser1);
                    intent2.putExtra("formationName", formationNameUser1);
                    intent2.putExtra("formationtime", formationtimeUser1);
                    startActivity(intent2);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_parametre:
                    showUserData2();
                    Intent intent4 = new Intent(getApplicationContext(), ParametresActivity.class);
                    intent4.putExtra("name", nameUser1);
                    intent4.putExtra("email", emailUser1);
                    intent4.putExtra("username", usernameUser1);
                    intent4.putExtra("formationName", formationNameUser1);
                    intent4.putExtra("formationtime", formationtimeUser1);
                    startActivity(intent4);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_profil:
                    return true;
            }
            return false;
        });

        tempsformation1 = (TextView) findViewById(R.id.tempsformation1);
        nomformation1 = (TextView) findViewById(R.id.nomformation1);
        profileEmail = (TextView) findViewById(R.id.profileEmail);
        profileUsername = (TextView) findViewById(R.id.profileUsername);
        titleName = (TextView) findViewById(R.id.titleName);

        showUserData2();

        nomformation1.setText(formationNameUser1);
        profileEmail.setText(emailUser1);
        profileUsername.setText(usernameUser1);
        tempsformation1.setText(formationtimeUser1);
        titleName.setText(nameUser1);
    }
    private void showUserData2(){

        Intent intent = getIntent();

        nameUser1 = intent.getStringExtra("name");
        emailUser1 = intent.getStringExtra("email");
        usernameUser1 = intent.getStringExtra("username");
        formationNameUser1 = intent.getStringExtra("formationName");
        formationtimeUser1 = intent.getStringExtra("formationtime");
    }
//    private void passUserData() {
//        String userUsername = profileUsername.getText().toString().trim();
//
//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
//        Query checkUserDatabase = reference.orderByChild("username").equalTo(userUsername);
//
//        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if (snapshot.exists()) {
//
//                    String nameFromDB = snapshot.child(userUsername).child("name").getValue(String.class);
//                    String emailFromDB = snapshot.child(userUsername).child("email").getValue(String.class);
//                    String passwordFromDB = snapshot.child(userUsername).child("password").getValue(String.class);
//                    String usernameFromDB = snapshot.child(userUsername).child("username").getValue(String.class);
//                    String formationNameFromDB = snapshot.child(userUsername).child("formationName").getValue(String.class);
//                    String formationtimeFromDB = snapshot.child(userUsername).child("formationtime").getValue(String.class);
//
//
//                    Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
//
//                    intent.putExtra("name", nameFromDB);
//                    intent.putExtra("email", emailFromDB);
//                    intent.putExtra("username", usernameFromDB);
//                    intent.putExtra("password", passwordFromDB);
//                    intent.putExtra("formationName", formationNameFromDB);
//                    intent.putExtra("formationtime", formationtimeFromDB);
//                    startActivity(intent);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    }
//    private void showUserData(){
//
//        Intent intent = getIntent();
//        String textName = intent.getStringExtra("name");
//        String textEmail = intent.getStringExtra("email");
//        String textUsername = intent.getStringExtra("username");
//        String textNameFormation = intent.getStringExtra("formationName");
//        String textTimeFormation = intent.getStringExtra("formationtime");
//
//        nomformation1.setText(textNameFormation);
//        profileEmail.setText(textEmail);
//        profileUsername.setText(textUsername);
//        tempsformation1.setText(textTimeFormation);
//        titleName.setText(textName);
//    }
}