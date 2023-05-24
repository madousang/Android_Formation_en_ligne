package com.example.firebase_register;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
//import android.view.View;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;
import java.util.Objects;

public class SignupActivity extends AppCompatActivity {
    private EditText signupName, signupEmail, signupUsername, signupPassword;
    private TextView loginRedirectText;
    private Button signupButton;
    private FirebaseDatabase database;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signupName = findViewById(R.id.signup_name);
        signupEmail = findViewById(R.id.signup_email);
        signupUsername = findViewById(R.id.signup_username);
        signupPassword = findViewById(R.id.signup_password);
        signupButton = findViewById(R.id.signup_button);
        loginRedirectText = findViewById(R.id.loginRedirectText);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser(v);
            }
        });

        loginRedirectText.setOnClickListener(view -> {
            Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }
    private Boolean validateName() {
        String val = signupName.getText().toString();
        if (val.isEmpty()) {
            signupName.setError("Ce champ ne peut pas être vide");
            return false;
        }
        else {
            signupName.setError(null);
            return true;
        }
    }
    private Boolean validateUsername() {
        String val = signupUsername.getText().toString();
        String noWhiteSpace = "\\A\\w{4,20}\\z";
        if (val.isEmpty()) {
            signupUsername.setError("Ce champ ne peut pas être vide");
            return false;
        } else if (val.length() >= 15) {
            signupUsername.setError("Ce pseudo est trop long");
            return false;
        } else if (!val.matches(noWhiteSpace)) {
            signupUsername.setError("Les espaces blancs ne sont pas autorisés");
            return false;
        } else {
            signupUsername.setError(null);
            return true;
        }
    }
    private Boolean validateEmail() {
        String val = signupEmail.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (val.isEmpty()) {
            signupEmail.setError("Ce champ ne peut pas être vide");
            return false;
        } else if (!val.matches(emailPattern)) {
            signupEmail.setError("Adresse email invalide");
            return false;
        } else {
            signupEmail.setError(null);
            return true;
        }
    }
    private Boolean validatePassword() {
        String val = signupPassword.getText().toString();
        String passwordVal = "^" +
                "(?=.*[a-zA-Z])" +
                "(?=.*[@#$%^&+=])" +
                "(?=\\S+$)" +
                ".{4,}" +
                "$";
        if (val.isEmpty()) {
            signupPassword.setError("Ce champ ne peut pas être vide");
            return false;
        } else if (!val.matches(passwordVal)) {
            signupPassword.setError("Le mot de passe est trop faible");
            return false;
        } else {
            signupPassword.setError(null);
            return true;
        }
    }
    public void registerUser(View view) {
        if(!validateName() |!validatePassword() | !validateEmail() | !validateUsername()) {
            return;
        }
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("users");

        String name = signupName.getText().toString();
        String email = signupEmail.getText().toString();
        String username = signupUsername.getText().toString();
        String password = signupPassword.getText().toString();

        HelperClass users = new HelperClass(name, email, username, password);

        reference.child(username).setValue(users);

        Toast.makeText(SignupActivity.this, "Inscription réussie !", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(SignupActivity.this, HomeActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("username", username);
        intent.putExtra("email", email);
        intent.putExtra("password", password);
        startActivity(intent);
    }
}