package com.github.spelrawler.gamebase.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.github.spelrawler.gamebase.models.Image;
import com.github.spelrawler.gamebase.mvp.views.ImagesView;

/**
 * Created by Spel on 28.05.2017.
 */

@InjectViewState
public class ImagePresenter extends MvpPresenter<ImagesView> {

    private Image[] mImages;
    private int mPosition;

    public ImagePresenter(Image[] images, int position) {
        mImages = images;
        mPosition = position;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().setImages(mImages, mPosition);
    }

}
