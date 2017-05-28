package com.github.spelrawler.gamebase.ui.activities;

import android.os.Bundle;

import com.github.spelrawler.gamebase.R;

public class SplashScreen extends BaseActivity {


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
