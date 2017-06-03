package com.ailynx.pekatala.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ailynx.pekatala.R;
import com.ailynx.pekatala.data.UserSettings;

public class SplashActivity extends AppCompatActivity {
    private static final int SPLASH_TIME = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        checkLogin();
    }

    private void checkLogin(){
        UserSettings userSettings = UserSettings.newInstance(SplashActivity.this);
        if (!userSettings.isLoggedIn()){
            startLogin();
        } else {
            startHome();
        }
    }

    private void startLogin(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                SplashActivity.this.finish();
            }
        }, SPLASH_TIME);
    }

    private void startHome(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(intent);
                SplashActivity.this.finish();
            }
        }, SPLASH_TIME);
    }
}
