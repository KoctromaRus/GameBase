package com.github.spelrawler.gamebase.app;

import android.app.Application;

import com.github.spelrawler.gamebase.di.AppComponent;
import com.github.spelrawler.gamebase.di.DaggerAppComponent;

/**
 * Created by Spel on 28.05.2017.
 */

public class GameBaseApp extends Application {

    private static AppComponent sAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        sAppComponent = DaggerAppComponent.builder().build();
    }

    public static AppComponent getAppComponent() {
        return sAppComponent;
    }

}


