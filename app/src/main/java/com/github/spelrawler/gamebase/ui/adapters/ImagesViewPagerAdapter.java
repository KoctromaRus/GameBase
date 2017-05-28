package com.github.spelrawler.gamebase.ui.adapters;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.github.spelrawler.gamebase.R;
import com.github.spelrawler.gamebase.mvp.models.Image;
import com.github.spelrawler.gamebase.ui.widgets.WebImageView;

/**
 * Created by Spel on 28.05.2017.
 */

public class ImagesViewPagerAdapter extends PagerAdapter {

    private Image[] mImages;

    public ImagesViewPagerAdapter(@NonNull Image[] images) {
        mImages = images;
    }

    @Override
    public int getCount() {
        return mImages.length;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        WebImageView webImageView = new WebImageView(collection.getContext());
        webImageView.setBackgroundColor(ContextCompat.getColor(collection.getContext(), R.color.black));
        webImageView.loadImage(mImages[position].getCloudinaryUrl());
        collection.addView(webImageView);

        return webImageView;
    }



    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

}
