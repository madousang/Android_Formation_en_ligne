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
    private ViewPager2 viewPager2;
    private Handler slideHandler = new Handler();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        profileName = findViewById(R.id.profileName);
        spinnerformation = findViewById(R.id.spinnerformation);
        spinnertime = findViewById(R.id.spinnertime);
        buttonsave = findViewById(R.id.btn_cours_ins);
        viewPager2 = findViewById(R.id.viewpager);

        List<SlideItem> slideItems = new ArrayList<>();
        slideItems.add(new SlideItem(R.drawable.informatik));
        slideItems.add(new SlideItem(R.drawable.telecom));
        slideItems.add(new SlideItem(R.drawable.btp));
        slideItems.add(new SlideItem(R.drawable.mecanique));
        slideItems.add(new SlideItem(R.drawable.energetique));
        slideItems.add(new SlideItem(R.drawable.topo));
        viewPager2.setAdapter(new SlideAdapter(slideItems, viewPager2));

        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(5);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r*0.15f);
            }
        });
        viewPager2.setPageTransformer(compositePageTransformer);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                slideHandler.removeCallbacks(slideRunnable);
                slideHandler.postDelayed(slideRunnable, 2000);
            }
        });


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
        reference = FirebaseDatabase.getInstance().getReference("formation").child(usernameUser);

        String nameformation = spinnerformation.getSelectedItem().toString();
        String timeformation = spinnertime.getSelectedItem().toString();

        Formation formation = new Formation(nameformation, timeformation);

        reference.setValue(formation);

        Toast.makeText(HomeActivity.this, "Enregistrement réussi", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);

        intent.putExtra("name", nameUser);
        intent.putExtra("email", emailUser);
        intent.putExtra("username", usernameUser);
        intent.putExtra("formationName", nameformation);
        intent.putExtra("formationtime", timeformation);
        startActivity(intent);
    }
    private Runnable slideRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        slideHandler.removeCallbacks(slideRunnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        slideHandler.postDelayed(slideRunnable,3000);
    }
}