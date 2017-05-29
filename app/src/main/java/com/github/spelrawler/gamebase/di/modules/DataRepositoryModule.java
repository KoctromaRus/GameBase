package com.github.spelrawler.gamebase.di.modules;

import com.github.spelrawler.gamebase.mvp.DataRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Spel on 30.05.2017.
 */

@Module
public class DataRepositoryModule {

    @Provides
    @Singleton
    DataRepository provideDataRepository() {
        return new DataRepository();
    }

}
