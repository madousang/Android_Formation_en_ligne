package com.example.firebase_register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class EditProfileActivity extends AppCompatActivity {

    private EditText editName, editEmail, editpassword;
    private Button saveButton;
    private String nameUser, emailUser, usernameUser, passwordUser;
    private DatabaseReference reference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        reference = FirebaseDatabase.getInstance().getReference("users");

        editName = (EditText) findViewById(R.id.editName);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editpassword = (EditText) findViewById(R.id.editpassword);
        saveButton = (Button) findViewById(R.id.saveButton);

        showData();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isNameChanged() || isEmailChanged() || isPasswordChanged()) {
                    Toast.makeText(EditProfileActivity.this, "Les modifications ont été prises en compte", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EditProfileActivity.this, "Aucune modification effectuée", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public boolean isNameChanged(){
        if (!nameUser.equals(editName.getText().toString())){
            reference.child(usernameUser).child("name").setValue(editName.getText().toString());
            nameUser = editName.getText().toString();
            return true;
//            if (nameUser.isEmpty()) {
//                editName.setError("Ce champ ne peut pas être vide");
//                return false;
//            }
//            else {
//                editName.setError(null);
//                return true;
//            }
        } else{
            return false;
        }
    }

    public boolean isEmailChanged(){
        if (!emailUser.equals(editName.getText().toString())){
            reference.child(usernameUser).child("email").setValue(editEmail.getText().toString());
            emailUser = editEmail.getText().toString();
//            String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
//            if (emailUser.isEmpty()) {
//                editEmail.setError("Ce champ ne peut pas être vide");
//                return false;
//            } else if (!emailUser.matches(emailPattern)) {
//                editEmail.setError("Adresse email invalide");
//                return false;
//            } else {
//                editEmail.setError(null);
//                return true;
//            }
            return true;
        } else{
            return false;
        }
    }
    public boolean isPasswordChanged(){
        if (!passwordUser.equals(editpassword.getText().toString())){
            reference.child(usernameUser).child("password").setValue(editpassword.getText().toString());
            passwordUser = editpassword.getText().toString();
//            String passwordVal = "^" +
//                    "(?=.*[a-zA-Z])" +
//                    "(?=.*[@#$%^&+=])" +
//                    "(?=\\S+$)" +
//                    ".{4,}" +
//                    "$";
//            if (passwordUser.isEmpty()) {
//                editpassword.setError("Ce champ ne peut pas être vide");
//                return false;
//            } else if (!passwordUser.matches(passwordVal)) {
//                editpassword.setError("Le mot de passe est trop faible");
//                return false;
//            } else {
//                editpassword.setError(null);
//                return true;
//            }
            return true;
        } else{
            return false;
        }
    }

    public void showData(){
        Intent intent = getIntent();

        nameUser = intent.getStringExtra("name");
        emailUser = intent.getStringExtra("email");
        usernameUser = intent.getStringExtra("username");
        passwordUser = intent.getStringExtra("password");

        editName.setText(nameUser);
        editEmail.setText(emailUser);
        editpassword.setText(passwordUser);
    }
//    private void passUserData(){
//        Intent intent = getIntent();
//        String usernameUser = intent.getStringExtra("username").trim();
//        Query checkUserDatabase = reference.orderByChild("username").equalTo(usernameUser);
//
//        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if (snapshot.exists()) {
//
//                    String nameFromDB = snapshot.child(usernameUser).child("name").getValue(String.class);
//                    String emailFromDB = snapshot.child(usernameUser).child("email").getValue(String.class);
//                    String passwordFromDB = snapshot.child(usernameUser).child("password").getValue(String.class);
//                    String usernameFromDB = snapshot.child(usernameUser).child("username").getValue(String.class);
//                    String formationNameFromDB = snapshot.child(usernameUser).child("formationName").getValue(String.class);
//                    String formationtimeFromDB = snapshot.child(usernameUser).child("formationtime").getValue(String.class);
//
//
//                    Toast.makeText(EditProfileActivity.this, "Les modifications ont été prises en compte", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    }
}