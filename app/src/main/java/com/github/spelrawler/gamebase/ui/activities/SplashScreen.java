package com.github.spelrawler.gamebase.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.spelrawler.gamebase.R;

public class SplashScreen extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        endSplash();
    }

    private void endSplash() {
        startActivity(GamesActivity.createIntent(this));
    }

}
