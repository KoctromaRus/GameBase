package com.github.spelrawler.gamebase.ui.activities;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.transition.AutoTransition;
import android.transition.Transition;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.github.spelrawler.gamebase.R;
import com.github.spelrawler.gamebase.mvp.models.Company;
import com.github.spelrawler.gamebase.mvp.models.Game;
import com.github.spelrawler.gamebase.mvp.models.Image;
import com.github.spelrawler.gamebase.mvp.models.Video;
import com.github.spelrawler.gamebase.mvp.presenters.GamePresenter;
import com.github.spelrawler.gamebase.mvp.views.GameView;
import com.github.spelrawler.gamebase.ui.adapters.MediaAdapter;
import com.github.spelrawler.gamebase.ui.adapters.TransitionRecyclerView;
import com.github.spelrawler.gamebase.ui.widgets.WebImageView;
import com.github.spelrawler.gamebase.utils.DateUtils;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GameActivity extends BaseActivity implements GameView, MediaAdapter.OnImageClickListener, MediaAdapter.OnVideoClickListener, Transition.TransitionListener {

    private static final String EXTRA_GAME_ID = "gameId";
    private static final String FORMAT_APP_URI = "vnd.youtube:%s";
    private static final String FORMAT_WEB_URI = "https://www.youtube.com/watch?v=%s";

    @InjectPresenter
    GamePresenter mGamePresenter;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    @BindView(R.id.image_cover)
    WebImageView mCoverImageView;
    @BindView(R.id.text_description)
    TextView mDescriptionTextView;
    @BindView(R.id.recycler_media)
    TransitionRecyclerView mMediaRecyclerView;
    @BindView(R.id.text_release_date)
    TextView mReleaseDateTextView;
    @BindView(R.id.text_developer)
    TextView mDeveloperTextView;
    @BindView(R.id.text_publisher)
    TextView mPublisherTextView;

    private MediaAdapter mMediaAdapter;

    @ProvidePresenter
    GamePresenter provideDetailsPresenter() {
        return new GamePresenter(getIntent().getLongExtra(EXTRA_GAME_ID, 0));
    }

    public static Intent createIntent(Context context, long gameId) {
        Intent intent = new Intent(context, GameActivity.class);
        intent.putExtra(EXTRA_GAME_ID, gameId);

        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ButterKnife.bind(this);

        setupToolbar();
        mMediaAdapter = new MediaAdapter();
        mMediaAdapter.setOnImageClickListener(this);
        mMediaAdapter.setOnVideoClickListener(this);
        mMediaRecyclerView.setAdapter(mMediaAdapter);
        mMediaRecyclerView.setNestedScrollingEnabled(false);
    }

    private void setupToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return false;
    }

    @Override
    public void setGame(@NonNull Game game) {
        mCollapsingToolbarLayout.setTitle(game.getName());
        mCoverImageView.loadImage(game.getCoverUrl());
        mDescriptionTextView.setText(game.getSummary());
        mDescriptionTextView.setVisibility(TextUtils.isEmpty(game.getSummary()) ? View.GONE : View.VISIBLE);
        mReleaseDateTextView.setText(DateUtils.getYear(game.getFirstReleaseDate()));
        setupMedia(game.getVideos(), game.getScreenshots());
    }

    @Override
    public void setPublisher(Company publisher) {
        mPublisherTextView.setText(publisher.getName());
    }

    @Override
    public void setDeveloper(Company developer) {
        mDeveloperTextView.setText(developer.getName());
    }

    private void setupMedia(Video[] videos, Image[] screenshots) {
        if (screenshots == null) return;
        mMediaAdapter.setMedia(videos, screenshots);
    }

    @Override
    public void onImageClick(Image[] images, int position) {
        mGamePresenter.onImageClick(images, position);
    }

    @Override
    public void onVideoClick(String videoId) {
        mGamePresenter.onVideoClick(videoId);
    }

    @Override
    public void showVideo(String videoId) {
        try {
            Uri appUri = Uri.parse(String.format(Locale.getDefault(), FORMAT_APP_URI, videoId));
            startActivity(new Intent(Intent.ACTION_VIEW, appUri));
        } catch (ActivityNotFoundException ex) {
            Uri webUri = Uri.parse(String.format(Locale.getDefault(), FORMAT_WEB_URI, videoId));
            startActivity(new Intent(Intent.ACTION_VIEW, webUri));
        }
    }

    @Override
    public void showImage(Image[] images, int position) {
        Bundle options = mMediaRecyclerView.createTransitionBundleForPosition(this, mMediaAdapter.getAdapterPosition(position));
        startActivity(ImagesActivity.createIntent(this, images, position), options);
    }

    @Override
    public void onTransitionStart(Transition transition) {

    }

    @Override
    public void onTransitionEnd(Transition transition) {

    }

    @Override
    public void onTransitionCancel(Transition transition) {

    }

    @Override
    public void onTransitionPause(Transition transition) {

    }

    @Override
    public void onTransitionResume(Transition transition) {

    }

}
