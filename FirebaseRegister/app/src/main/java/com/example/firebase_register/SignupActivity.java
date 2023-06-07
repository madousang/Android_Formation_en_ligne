package com.example.firebase_register;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {
    private EditText signupName, signupEmail, signupUsername, signupPassword;
    private TextView loginRedirectText;
    private Button signupButton;
    private FirebaseAuth auth;
    private DatabaseReference database;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        database = FirebaseDatabase.getInstance().getReference("users");
        auth = FirebaseAuth.getInstance();

        signupName = findViewById(R.id.signup_name);
        signupEmail = findViewById(R.id.signup_email);
        signupUsername = findViewById(R.id.signup_username);
        signupPassword = findViewById(R.id.signup_password);
        signupButton = findViewById(R.id.s_inscrire);
        loginRedirectText = findViewById(R.id.loginRedirectText);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

        loginRedirectText.setOnClickListener(view -> {
            Intent intent = new Intent(SignupActivity.this, ConnexionActivity.class);
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
    public void registerUser() {
        String name = signupName.getText().toString().trim();
        String email = signupEmail.getText().toString().trim();
        String username = signupUsername.getText().toString().trim();
        String password = signupPassword.getText().toString().trim();

        if (!(validateName() | validateEmail() | validateUsername() | validatePassword())) {
            return;
        }
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    HelperClass users = new HelperClass(name, email, username, password);
                    database.child(username).setValue(users);

                    Toast.makeText(SignupActivity.this, "Inscription réussie !", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(SignupActivity.this, HomeActivity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("username", username);
                    intent.putExtra("email", email);
                    intent.putExtra("password", password);
                    startActivity(intent);
                } else {
                    Toast.makeText(SignupActivity.this, "Incription échouée", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}