package com.example.firebase_register.principale_activite;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.firebase_register.R;

@SuppressLint("CustomSplashScreen")
public class DemarrageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demarrage);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        final Thread thread = new Thread(){
            public void run(){
                try {
                    sleep(3000);

                }catch (InterruptedException e){
                    e.printStackTrace();

                }finally {
                    Intent intent = new Intent("android.intent.action.CONNEXIONACTIVITY");
                    startActivity(intent);
                    finish();
                }

            }
        };
        thread.start();

    }

}