package com.example.smail.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.smail.R;
import com.example.smail.fragments.MainFragment;

public class MainActivity extends AppCompatActivity {
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
         image = findViewById(R.id.profile_image2);
        FrameLayout fm =findViewById(R.id.framS);
        image.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,Settings.class);
            startActivity(intent);
            finish();
        });
        MainFragment mainFragment =new MainFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framS,mainFragment);
        fragmentTransaction.commit();
    }
}