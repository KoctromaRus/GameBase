package com.github.spelrawler.gamebase.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.github.spelrawler.gamebase.app.GameBaseApp;
import com.github.spelrawler.gamebase.models.Game;
import com.github.spelrawler.gamebase.mvp.IgdbService;
import com.github.spelrawler.gamebase.mvp.views.GamesView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Spel on 28.05.2017.
 */


@InjectViewState
public class GamesPresenter extends MvpPresenter<GamesView> {

    @Inject
    IgdbService mIgdbService;

    public GamesPresenter() {
        GameBaseApp.getAppComponent().inject(this);
    }

    public void updateGames() {
        mIgdbService.getGames(new IgdbService.Callback<List<Game>>() {
            @Override
            public void onDataFetched(List<Game> games) {
                onGamesLoaded(games, true);
            }

            @Override
            public void onError(String message) {
                GamesPresenter.this.onError(message);
            }
        });
    }

    public void loadMoreGames(int currentCount) {
        mIgdbService.getGames(currentCount, new IgdbService.Callback<List<Game>>() {
            @Override
            public void onDataFetched(List<Game> games) {
                onGamesLoaded(games, false);
            }

            @Override
            public void onError(String message) {
                GamesPresenter.this.onError(message);
            }
        });
    }

    private void onGamesLoaded(List<Game> games, boolean isFirstLoad) {
        if (isFirstLoad) {
            getViewState().setGames(games);
        } else {
            getViewState().addGames(games);
        }
    }

    private void onError(String error) {

    }

}
