package com.github.spelrawler.gamebase.mvp.views;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpView;
import com.github.spelrawler.gamebase.models.Game;

/**
 * Created by Spel on 28.05.2017.
 */

public interface GameView extends MvpView {

    void setGame(@NonNull Game game);

}
