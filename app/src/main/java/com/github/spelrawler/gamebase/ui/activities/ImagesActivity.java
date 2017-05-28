package com.github.spelrawler.gamebase.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.github.spelrawler.gamebase.R;
import com.github.spelrawler.gamebase.mvp.models.Image;
import com.github.spelrawler.gamebase.mvp.presenters.ImagePresenter;
import com.github.spelrawler.gamebase.mvp.views.ImagesView;
import com.github.spelrawler.gamebase.ui.adapters.ImagesViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImagesActivity extends BaseActivity implements ImagesView {

    private static final String EXTRA_IMAGES = "images";
    private static final String EXTRA_POSITION = "position";

    @InjectPresenter
    ImagePresenter mImagePresenter;

    @BindView(R.id.viewpager)
    ViewPager mViewPager;


    public static Intent createIntent(Context context, Image[] images, int position) {
        Intent intent = new Intent(context, ImagesActivity.class);
        intent.putExtra(EXTRA_IMAGES, images);
        intent.putExtra(EXTRA_POSITION, position);

        return intent;
    }

    @ProvidePresenter
    ImagePresenter providePresenter() {
        Image[] images = (Image[]) getIntent().getSerializableExtra(EXTRA_IMAGES);
        int position = getIntent().getIntExtra(EXTRA_POSITION, 0);

        return new ImagePresenter(images, position);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ButterKnife.bind(this);
    }

    @Override
    public void setImages(@NonNull Image[] images, int position) {
        ImagesViewPagerAdapter adapter = new ImagesViewPagerAdapter(images);
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(position);
    }
}
