package com.example.firebase_register.tableau_de_bord;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.firebase_register.principale_activite.FollowingFormation;
import com.example.firebase_register.Formation;
import com.example.firebase_register.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DataScienceActivity extends AppCompatActivity {
    private TextView textDure;
    private TextView nameformation;
    private String nameUser, emailUser, usernameUser, passwordUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_science);

        textDure = findViewById(R.id.dureeDtaScience);
        TextView textRythme = findViewById(R.id.rythmeDataScience);
        nameformation = findViewById(R.id.DataScienceTitle);
        Button btnDataScienceFollow = findViewById(R.id.btnDataScience);

        String DURE = "6 semaines";
        textDure.setText(DURE);
        String RYTHME = "Auto-rythmé";
        textRythme.setText(RYTHME);

        Intent intent = getIntent();
        nameUser = intent.getStringExtra("name");
        emailUser = intent.getStringExtra("email");
        usernameUser = intent.getStringExtra("username");
//        passwordUser = intent.getStringExtra("password");
        btnDataScienceFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveFormation();
            }
        });
    }
    private void saveFormation() {
        DatabaseReference database = FirebaseDatabase.getInstance().getReference("formation");
        String strTimeFormation = textDure.getText().toString().trim();
        String strNameFormation = nameformation.getText().toString().trim();

        if (!TextUtils.isEmpty(strNameFormation)) {
            Formation formation = new Formation(strNameFormation, strTimeFormation, usernameUser);

            database.child(usernameUser).setValue(formation);

            Toast.makeText(DataScienceActivity.this, "Enregistrement réussi", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(DataScienceActivity.this, FollowingFormation.class);

            intent.putExtra("name", nameUser);
            intent.putExtra("email", emailUser);
            intent.putExtra("username", usernameUser);
//            intent.putExtra("password", passwordUser);
            intent.putExtra("formationName", strNameFormation);
            intent.putExtra("formationtime", strTimeFormation);
            startActivity(intent);
        }
    }
}