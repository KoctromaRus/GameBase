package com.github.spelrawler.gamebase.ui.adapters;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.spelrawler.gamebase.R;
import com.github.spelrawler.gamebase.mvp.models.Game;
import com.github.spelrawler.gamebase.ui.widgets.WebImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Spel on 28.05.2017.
 */

public class GamesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Game> mGames;
    @Nullable
    private OnScrollToBottomListener mOnScrollToBottomListener;
    @Nullable
    private OnGameClickListener mOnGameClickListener;

    public GamesAdapter() {
        setHasStableIds(true);
    }

    @Override
    public int getItemViewType(int position) {
        return mGames == null || position == mGames.size() ? ViewType.PROGRESS : ViewType.GAME_CARD;
    }

    @Override
    public long getItemId(int position) {
        switch (getItemViewType(position)) {
            case ViewType.GAME_CARD:
                return mGames.get(position).getId();
            default:
                return Long.MAX_VALUE;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case ViewType.PROGRESS:
                View progressView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_progress, parent, false);
                return new ProgressViewHolder(progressView);
            case ViewType.GAME_CARD:
                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_game, parent, false);
                return new ViewHolder(itemView);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case ViewType.PROGRESS:
                onBindProgressViewHolder();
                break;
            case ViewType.GAME_CARD:
                onBindGameCardViewHolder((ViewHolder) holder, position);
                break;
        }
    }

    private void onBindGameCardViewHolder(ViewHolder holder, int position) {
        Game game = mGames.get(position);

        holder.title.setText(game.getName());
        holder.image.loadImage(game.getCoverUrl());
        holder.rating.setText(String.format(Locale.getDefault(), "%.0f", game.getRating()));
        holder.rating.setVisibility(game.getRating() == 0 ? View.GONE : View.VISIBLE);
        holder.summary.setText(game.getSummary());
        holder.summary.setVisibility(TextUtils.isEmpty(game.getSummary()) ? View.GONE : View.VISIBLE);
    }

    private void onBindProgressViewHolder() {
        if (mOnScrollToBottomListener != null) {
            mOnScrollToBottomListener.onScrollToBottom();
        }
    }

    @Override
    public int getItemCount() {
        return mGames == null ? 1 : mGames.size() + 1;
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
        if (mGames == null) {
            setGames(games);
            return;
        }
        mGames.addAll(games);
        notifyDataSetChanged();
    }

    private void onGameClick(View coverView, int position) {
        if (mOnGameClickListener != null) {
            mOnGameClickListener.onGameClick(coverView, mGames.get(position));
        }
    }

    public void setOnScrollToBottomListener(@Nullable OnScrollToBottomListener onScrollToBottomListener) {
        mOnScrollToBottomListener = onScrollToBottomListener;
    }

    public void setOnGameClickListener(@Nullable OnGameClickListener onGameClickListener) {
        mOnGameClickListener = onGameClickListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_title)
        TextView title;
        @BindView(R.id.image_cover)
        WebImageView image;
        @BindView(R.id.text_rating)
        TextView rating;
        @BindView(R.id.text_summary)
        TextView summary;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.view_click)
        public void onClick() {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                onGameClick(image, position);
            }
        }
    }

    class ProgressViewHolder extends RecyclerView.ViewHolder {

        public ProgressViewHolder(View itemView) {
            super(itemView);
        }
    }

    public interface OnScrollToBottomListener {
        void onScrollToBottom();
    }

    public interface OnGameClickListener {
        void onGameClick(View coverView, Game game);
    }

    public interface ViewType {
        int GAME_CARD = 0;
        int PROGRESS = 1;
    }

}
