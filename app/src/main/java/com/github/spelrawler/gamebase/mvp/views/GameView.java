package com.github.spelrawler.gamebase.mvp.views;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.github.spelrawler.gamebase.mvp.models.Company;
import com.github.spelrawler.gamebase.mvp.models.Game;
import com.github.spelrawler.gamebase.mvp.models.Image;

/**
 * Created by Spel on 28.05.2017.
 */


@StateStrategyType(AddToEndSingleStrategy.class)
public interface GameView extends MvpView {

    void setGame(@NonNull Game game);
    void setPublisher(Company publisher);
    void setDeveloper(Company developer);
    @StateStrategyType(SkipStrategy.class)
    void showVideo(String videoId);
    @StateStrategyType(SkipStrategy.class)
    void showImage(Image[] images, int position);

}
