package com.github.spelrawler.gamebase.di;

import com.github.spelrawler.gamebase.di.modules.DataRepositoryModule;
import com.github.spelrawler.gamebase.di.modules.IgdbModule;
import com.github.spelrawler.gamebase.mvp.presenters.GamePresenter;
import com.github.spelrawler.gamebase.mvp.presenters.GamesPresenter;
import com.github.spelrawler.gamebase.ui.activities.SplashScreen;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Spel on 28.05.2017.
 */

@Singleton
@Component(modules = {IgdbModule.class, DataRepositoryModule.class})
public interface AppComponent {
    void inject(SplashScreen splashScreen);

    void inject(GamesPresenter gamesPresenter);

    void inject(GamePresenter gamePresenter);
}
