package com.github.spelrawler.gamebase.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.github.spelrawler.gamebase.models.Game;

import java.util.List;

/**
 * Created by Spel on 28.05.2017.
 */


@StateStrategyType(AddToEndSingleStrategy.class)
public interface GamesView extends MvpView {

    void setGames(List<Game> games);

    void addGames(List<Game> games);

}
