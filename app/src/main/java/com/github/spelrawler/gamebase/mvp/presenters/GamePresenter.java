package com.github.spelrawler.gamebase.mvp.presenters;

import android.support.annotation.Nullable;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.github.spelrawler.gamebase.app.GameBaseApp;
import com.github.spelrawler.gamebase.mvp.IgdbService;
import com.github.spelrawler.gamebase.mvp.models.Company;
import com.github.spelrawler.gamebase.mvp.models.Game;
import com.github.spelrawler.gamebase.mvp.models.Image;
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

    public void onVideoClick(String videoId) {
        getViewState().showVideo(videoId);
    }

    public void onImageClick(Image[] images, int position) {
        getViewState().showImage(images, position);
    }

    @Override
    public void onDataFetched(Game game) {
        if (game != null) {
            getViewState().setGame(game);
            if (game.getDevelopers() != null) {
                loadDeveloper(game.getDevelopers()[0]);
            }
            if (game.getPublishers() != null) {
                loadPublisher(game.getPublishers()[0]);
            }
        }
    }

    private void loadPublisher(long id) {
        mIgdbService.getCompany(id, new IgdbService.Callback<Company>() {
            @Override
            public void onDataFetched(Company company) {
                getViewState().setPublisher(company);
            }

            @Override
            public void onError(@Nullable String message) { }
        });
    }

    private void loadDeveloper(long id) {
        mIgdbService.getCompany(id, new IgdbService.Callback<Company>() {
            @Override
            public void onDataFetched(Company company) {
                getViewState().setDeveloper(company);
            }

            @Override
            public void onError(@Nullable String message) { }
        });
    }


    @Override
    public void onError(@Nullable String message) {

    }

}
