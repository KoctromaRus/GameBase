package com.github.spelrawler.gamebase.mvp.presenters;

import android.support.annotation.Nullable;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.github.spelrawler.gamebase.app.GameBaseApp;
import com.github.spelrawler.gamebase.models.Game;
import com.github.spelrawler.gamebase.mvp.IgdbService;
import com.github.spelrawler.gamebase.mvp.views.GameView;

import javax.inject.Inject;

/**
 * Created by Spel on 28.05.2017.
 */

@InjectViewState
public class GamePresenter extends MvpPresenter<GameView> implements IgdbService.Callback<Game> {

    @Inject
    IgdbService mIgdbService;

    private long mGameId;


    public GamePresenter(long gameId) {
        mGameId = gameId;
        GameBaseApp.getAppComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        mIgdbService.getGame(mGameId, this);
    }

    @Override
    public void onDataFetched(Game game) {
        if (game != null) {
            getViewState().setGame(game);
        }
    }

    @Override
    public void onError(@Nullable String message) {

    }

}
