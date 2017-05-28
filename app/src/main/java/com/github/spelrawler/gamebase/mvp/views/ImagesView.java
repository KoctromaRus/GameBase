package com.github.spelrawler.gamebase.mvp.views;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpView;
import com.github.spelrawler.gamebase.models.Image;

/**
 * Created by Spel on 28.05.2017.
 */

public interface ImagesView extends MvpView {

    void setImages(@NonNull Image[] images, int position);

}
