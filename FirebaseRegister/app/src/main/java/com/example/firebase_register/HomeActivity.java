package com.example.firebase_register;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;
import java.util.List;
public class HomeActivity extends AppCompatActivity {
    private Button buttonsave;
    private TextView profileName;
    private Spinner spinnerformation, spinnertime;
    private String nameUser, emailUser, usernameUser;
    private DatabaseReference reference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        profileName = findViewById(R.id.profileName);
        spinnerformation = findViewById(R.id.spinnerformation);
        spinnertime = findViewById(R.id.spinnertime);
        buttonsave = findViewById(R.id.enregistrer);

        Intent intent = getIntent();
        nameUser = intent.getStringExtra("name");
        emailUser = intent.getStringExtra("email");
        usernameUser = intent.getStringExtra("username");
        profileName.setText(nameUser);

        buttonsave.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick (View v){
                saveFormation();
            }
        });
    }
    private void saveFormation() {
        reference = FirebaseDatabase.getInstance().getReference("formation");

        String nameformation = spinnerformation.getSelectedItem().toString().trim();
        String timeformation = spinnertime.getSelectedItem().toString();

        if (!TextUtils.isEmpty(nameformation)){
            Formation formation = new Formation(nameformation, timeformation, usernameUser);

            reference.child(usernameUser).setValue(formation);

            Toast.makeText(HomeActivity.this, "Enregistrement réussi", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(HomeActivity.this, FollowingFormation.class);

            intent.putExtra("name", nameUser);
            intent.putExtra("email", emailUser);
            intent.putExtra("username", usernameUser);
            intent.putExtra("formationName", nameformation);
            intent.putExtra("formationtime", timeformation);
            startActivity(intent);
        }
    }
}