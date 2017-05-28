package com.github.spelrawler.gamebase.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.util.Pair;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.github.spelrawler.gamebase.R;
import com.github.spelrawler.gamebase.models.Game;
import com.github.spelrawler.gamebase.models.Image;
import com.github.spelrawler.gamebase.mvp.presenters.GamePresenter;
import com.github.spelrawler.gamebase.mvp.views.GameView;
import com.github.spelrawler.gamebase.ui.adapters.ScreenshotsAdapter;
import com.github.spelrawler.gamebase.ui.widgets.WebImageView;
import com.github.spelrawler.gamebase.utils.TransitionUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GameActivity extends BaseActivity implements GameView, ScreenshotsAdapter.OnImageClickListener {

    private static final String EXTRA_GAME_ID = "gameId";

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
    @BindView(R.id.recycler_screenshots)
    RecyclerView mScreenshotsRecyclerView;

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
        setupScreenshots(game.getScreenshots());
    }

    private void setupScreenshots(Image[] screenshots) {
        if (screenshots == null) return;
        ScreenshotsAdapter adapter = new ScreenshotsAdapter(screenshots);
        adapter.setOnImageClickListener(this);
        mScreenshotsRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onImageClick(View imageView, Image[] images, int position) {
        Bundle options = TransitionUtils.createSingleSharedElementOptions(this, Pair.create(imageView, getString(R.string.transition_screenshot)));
        startActivity(ImagesActivity.createIntent(this, images, position), options);
    }

}
