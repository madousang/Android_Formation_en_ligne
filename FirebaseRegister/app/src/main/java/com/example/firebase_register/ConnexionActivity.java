package com.example.firebase_register;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ConnexionActivity extends AppCompatActivity {

    private EditText loginUsername, loginPassword, loginEmail;
    private DatabaseReference database, database2;
    private FirebaseAuth auth;
    String formationNameFromDB, formationtimeFromDB;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        database = FirebaseDatabase.getInstance().getReference("users");
        database2 = FirebaseDatabase.getInstance().getReference("formation");
        auth = FirebaseAuth.getInstance();

        loginUsername = (EditText) findViewById(R.id.login_username);
        loginPassword = (EditText) findViewById(R.id.login_password);
        loginEmail = findViewById(R.id.login_email_);
        TextView signupRedirectText = (TextView) findViewById(R.id.signupRedirectText);
        TextView mot_d_pass_oub = (TextView) findViewById(R.id.mot_d_pass_oubli);
        Button loginButton = (Button) findViewById(R.id.s_connect);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkUser();
            }
        });
        mot_d_pass_oub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ConnexionActivity.this);
                View dialogView = getLayoutInflater().inflate(R.layout.dialog_forgot, null);
                EditText emailBox = dialogView.findViewById(R.id.emailBox);
                builder.setView(dialogView);
                AlertDialog dialog = builder.create();
                dialogView.findViewById(R.id.btnReset).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String userEmail = emailBox.getText().toString();
                        if (TextUtils.isEmpty(userEmail) && !Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()){
                            Toast.makeText(ConnexionActivity.this, "Entrer votre adresse email enregistré", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        auth.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(ConnexionActivity.this, "Vérifier votre email", Toast.LENGTH_SHORT).show();
                                    dialog.dismiss();
                                } else {
                                    Toast.makeText(ConnexionActivity.this, "Impossible d'envoyer, échoué", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                });
                dialogView.findViewById(R.id.btnCancel).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                if (dialog.getWindow() != null){
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                }
                dialog.show();
            }
        });
        signupRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ConnexionActivity.this, SignupActivity.class));
            }
        });
    }
    private Boolean validateUsername(){
        String val = loginUsername.getText().toString();
        if (val.isEmpty()){
            loginUsername.setError("Ce champ ne peut pas être vide");
            return false;
        } else {
            loginUsername.setError(null);
            return true;
        }
    }

    private Boolean validatePassword(){
        String val = loginPassword.getText().toString();
        if (val.isEmpty()){
            loginPassword.setError("Ce champx ne peut pas être vide");
            return false;
        } else {
            loginPassword.setError(null);
            return true;
        }
    }
    private void checkUser(){
        String userUsername = loginUsername.getText().toString();
        String userPassword = loginPassword.getText().toString();
        String email = loginEmail.getText().toString();

        if (!(validateUsername() | validatePassword())){
            return;
        }
        Query checkUserDatabase2 = database2.orderByChild("username").equalTo(userUsername);
        checkUserDatabase2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                formationNameFromDB = snapshot.child(userUsername).child("formationName").getValue(String.class);
                formationtimeFromDB = snapshot.child(userUsername).child("formationtime").getValue(String.class);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        Query checkUserDatabase = database.orderByChild("username").equalTo(userUsername);
        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()){
                    loginUsername.setError(null);
                    String passwordFromDB = snapshot.child(userUsername).child("password").getValue(String.class);
                    if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                        if (!userPassword.isEmpty()) {
                            loginUsername.setError(null);

                            String nameFromDB = snapshot.child(userUsername).child("name").getValue(String.class);
                            String emailFromDB = snapshot.child(userUsername).child("email").getValue(String.class);
                            String usernameFromDB = snapshot.child(userUsername).child("username").getValue(String.class);

                            auth.signInWithEmailAndPassword(email, userPassword)
                                    .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                        @Override
                                        public void onSuccess(AuthResult authResult) {
                                            Toast.makeText(ConnexionActivity.this, "Vous êtes connecté", Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(ConnexionActivity.this, FollowingFormation.class);

                                            intent.putExtra("name", nameFromDB);
                                            intent.putExtra("email", emailFromDB);
                                            intent.putExtra("username", usernameFromDB);
                                            intent.putExtra("password", passwordFromDB);
                                            intent.putExtra("formationName", formationNameFromDB);
                                            intent.putExtra("formationtime", formationtimeFromDB);

                                            startActivity(intent);
                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(ConnexionActivity.this, "Connexion échouée", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                        } else {
                            loginPassword.setError("Mot de passe invalide");
                            loginPassword.requestFocus();
                        }
                    } else if (email.isEmpty()) {
                        loginEmail.setError("Les champs vides ne sont pas autorisés");
                    } else {
                        loginEmail.setError("Veuillez saisir une adresse e-mail correcte");
                    }
                } else {
                    loginUsername.setError("Ce pseudo n'existe pas");
                    loginUsername.requestFocus();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
