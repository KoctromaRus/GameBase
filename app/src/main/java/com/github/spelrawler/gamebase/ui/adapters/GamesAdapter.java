package com.github.spelrawler.gamebase.ui.adapters;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.spelrawler.gamebase.R;
import com.github.spelrawler.gamebase.models.Game;
import com.github.spelrawler.gamebase.ui.widgets.WebImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Spel on 28.05.2017.
 */

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.ViewHolder> {

    private List<Game> mGames;

    public GamesAdapter() {
        setHasStableIds(true);
    }

    @Override
    public long getItemId(int position) {
        return mGames.get(position).getId();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_game, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Game game = mGames.get(position);

        holder.title.setText(game.getName());
        holder.image.loadImage(game.getCoverUrl());
    }

    @Override
    public int getItemCount() {
        return mGames == null ? 0 : mGames.size();
    }

    public void setGames(@Nullable List<Game> games) {
        if (games == null) {
            mGames = null;
        } else {
            mGames = new ArrayList<>(games);
        }

        notifyDataSetChanged();
    }

    public void addGames(@Nullable List<Game> games) {
        if (games == null) return;
        mGames.addAll(games);
        notifyDataSetChanged();
    }

    private void onGameClick(int position) {

    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_title)
        TextView title;
        @BindView(R.id.image_cover)
        WebImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.view_click)
        public void onClick() {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                onGameClick(position);
            }
        }
    }

}
