package com.github.spelrawler.gamebase.di.modules;

import com.github.spelrawler.gamebase.api.GamesApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Spel on 28.05.2017.
 */

@Module(includes = RetrofitModule.class)
public class ApiModule {

    @Provides
    @Singleton
    public GamesApi provideGamesApi(Retrofit retrofit) {
        return retrofit.create(GamesApi.class);
    }

}
