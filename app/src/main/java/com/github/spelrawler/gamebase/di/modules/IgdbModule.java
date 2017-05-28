package com.github.spelrawler.gamebase.di.modules;

import com.github.spelrawler.gamebase.api.GamesApi;
import com.github.spelrawler.gamebase.mvp.IgdbService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Spel on 28.05.2017.
 */

@Module(includes = ApiModule.class)
public class IgdbModule {

    @Singleton
    @Provides
    public IgdbService provideIgdbService(GamesApi gamesApi) {
        return new IgdbService(gamesApi);
    }

}
