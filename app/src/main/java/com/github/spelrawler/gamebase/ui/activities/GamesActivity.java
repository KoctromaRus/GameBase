package com.github.spelrawler.gamebase.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.github.spelrawler.gamebase.R;
import com.github.spelrawler.gamebase.mvp.models.Game;
import com.github.spelrawler.gamebase.mvp.presenters.GamesPresenter;
import com.github.spelrawler.gamebase.mvp.views.GamesView;
import com.github.spelrawler.gamebase.ui.adapters.GamesAdapter;
import com.github.spelrawler.gamebase.ui.adapters.TransitionRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GamesActivity extends BaseActivity implements GamesView, GamesAdapter.OnScrollToBottomListener, GamesAdapter.OnGameClickListener {

    @InjectPresenter
    GamesPresenter mGamesPresenter;

    @BindView(R.id.recycler_games)
    TransitionRecyclerView mGamesRecyclerView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private GamesAdapter mGamesAdapter;


    public static Intent createIntent(Context context) {
        return new Intent(context, GamesActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        mGamesAdapter = new GamesAdapter();
        mGamesAdapter.setOnScrollToBottomListener(this);
        mGamesAdapter.setOnGameClickListener(this);
        mGamesRecyclerView.setAdapter(mGamesAdapter);
    }

    @Override
    public void setGames(List<Game> games) {
        mGamesAdapter.setGames(games);
    }

    @Override
    public void addGames(List<Game> games) {
        mGamesAdapter.addGames(games);
    }

    @Override
    public void showGame(Game game) {
        Bundle options = mGamesRecyclerView.createTransitionBundleForItemId(this, game.getId());
        startActivity(GameActivity.createIntent(this, game.getId()), options);
    }

    @Override
    public void onScrollToBottom() {
        mGamesPresenter.loadMoreGames(mGamesAdapter.getItemCount());
    }

    @Override
    public void onGameClick(Game game) {
        mGamesPresenter.onGameClick(game);
    }

}
