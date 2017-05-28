package com.github.spelrawler.gamebase.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.github.spelrawler.gamebase.R;
import com.github.spelrawler.gamebase.models.Game;
import com.github.spelrawler.gamebase.mvp.presenters.GamesPresenter;
import com.github.spelrawler.gamebase.mvp.views.GamesView;
import com.github.spelrawler.gamebase.ui.adapters.GamesAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GamesActivity extends MvpAppCompatActivity implements GamesView {

    @InjectPresenter
    GamesPresenter mGamesPresenter;

    @BindView(R.id.recycler_games)
    RecyclerView mGamesRecyclerView;

    private GamesAdapter mGamesAdapter;


    public static Intent createIntent(Context context) {
        return new Intent(context, GamesActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);
        ButterKnife.bind(this);
        mGamesAdapter = new GamesAdapter();
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

}
