package com.github.spelrawler.gamebase.mvp.views;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.github.spelrawler.gamebase.mvp.models.Image;

/**
 * Created by Spel on 28.05.2017.
 */


@StateStrategyType(AddToEndSingleStrategy.class)
public interface ImagesView extends MvpView {

    void setImages(@NonNull Image[] images, int position);

}
