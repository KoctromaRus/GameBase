package com.github.spelrawler.gamebase.mvp.presenters;

import android.support.annotation.Nullable;
import android.view.View;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.github.spelrawler.gamebase.app.GameBaseApp;
import com.github.spelrawler.gamebase.mvp.DataRepository;
import com.github.spelrawler.gamebase.mvp.IgdbService;
import com.github.spelrawler.gamebase.mvp.models.Game;
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
    @Inject
    DataRepository mDataRepository;

    public GamesPresenter() {
        GameBaseApp.getAppComponent().inject(this);
    }

    public void updateGames() {
        mIgdbService.getGames(mDataRepository.getFilters(), new IgdbService.Callback<List<Game>>() {
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
        mIgdbService.getGames(mDataRepository.getFilters(), currentCount, new IgdbService.Callback<List<Game>>() {
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

    public void onGameClick(View transitionView, Game game) {
        getViewState().showGame(transitionView, game);
    }

    public void onFilterClick() {
        mDataRepository.setTestFilters();
        getViewState().showFilters();
    }

    public void onFiltersUpdate() {
        mIgdbService.getGames(mDataRepository.getFilters(), new IgdbService.Callback<List<Game>>() {
            @Override
            public void onDataFetched(List<Game> games) {
                onGamesLoaded(games, true);
            }

            @Override
            public void onError(@Nullable String message) {
                GamesPresenter.this.onError(message);
            }
        });
    }

    private void onError(String error) {

    }

}
