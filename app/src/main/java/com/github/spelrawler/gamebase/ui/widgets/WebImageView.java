package com.github.spelrawler.gamebase.ui.widgets;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

/**
 * Created by Spel on 28.05.2017.
 */

public class WebImageView extends AppCompatImageView {

    public WebImageView(Context context) {
        super(context);
    }

    public WebImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public WebImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void loadImage(String url) {
        Picasso.with(getContext()).load(url).into(this, new Callback() {
            @Override
            public void onSuccess() {
                if (getContext() instanceof AppCompatActivity) {
                    ((AppCompatActivity) getContext()).supportStartPostponedEnterTransition();
                }
            }

            @Override
            public void onError() {
                if (getContext() instanceof AppCompatActivity) {
                    ((AppCompatActivity) getContext()).supportStartPostponedEnterTransition();
                }
            }
        });
    }

}
