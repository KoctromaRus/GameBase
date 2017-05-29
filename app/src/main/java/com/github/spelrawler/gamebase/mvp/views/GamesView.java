package com.github.spelrawler.gamebase.mvp.views;

import android.view.View;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.github.spelrawler.gamebase.mvp.models.Game;

import java.util.List;

/**
 * Created by Spel on 28.05.2017.
 */


@StateStrategyType(AddToEndSingleStrategy.class)
public interface GamesView extends MvpView {

    void setGames(List<Game> games);
    @StateStrategyType(AddToEndStrategy.class)
    void addGames(List<Game> games);
    @StateStrategyType(SkipStrategy.class)
    void showGame(View transitionView, Game game);
    @StateStrategyType(SkipStrategy.class)
    void showFilters();

}
