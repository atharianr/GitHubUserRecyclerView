package com.example.aplikasigithubuser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intentKeMain = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intentKeMain);
                finish();
            }
        }, 3000);
    }
}