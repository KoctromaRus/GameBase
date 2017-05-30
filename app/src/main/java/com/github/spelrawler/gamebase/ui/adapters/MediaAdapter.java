package com.github.spelrawler.gamebase.ui.adapters;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.spelrawler.gamebase.R;
import com.github.spelrawler.gamebase.mvp.models.Image;
import com.github.spelrawler.gamebase.mvp.models.TransitionBuilder;
import com.github.spelrawler.gamebase.mvp.models.Video;
import com.github.spelrawler.gamebase.ui.widgets.TransitionViewHolder;
import com.github.spelrawler.gamebase.ui.widgets.WebImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Spel on 28.05.2017.
 */

public class MediaAdapter extends RecyclerView.Adapter<TransitionViewHolder>  {

    private Image[] mImages = new Image[0];
    @Nullable
    private Video[] mVideos;
    @Nullable
    private OnImageClickListener mOnImageClickListener;
    @Nullable
    private OnVideoClickListener mOnVideoClickListener;

    public MediaAdapter() { }

    @Override
    public int getItemViewType(int position) {
        if (mVideos == null) return ViewType.IMAGE;
        return position < mVideos.length ? ViewType.VIDEO : ViewType.IMAGE;
    }

    public void setMedia(@Nullable Video[] videos, @NonNull Image[] images) {
        mImages = images;
        mVideos = videos;
        notifyDataSetChanged();
    }

    private int getImagePosition(int position) {
        return position - (mVideos == null ? 0 : mVideos.length);
    }

    public int getAdapterPosition(int imagePosition) {
        return mVideos == null ? imagePosition : mVideos.length + imagePosition;
    }

    @Override
    public TransitionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case ViewType.IMAGE:
                View imageView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
                return new ImageViewHolder(imageView);
            case ViewType.VIDEO:
                View videoView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false);
                return new VideoViewHolder(videoView);
            default:
                throw new IllegalArgumentException("Unknown viewType: " + viewType);
        }
    }

    @Override
    public void onBindViewHolder(TransitionViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case ViewType.IMAGE:
                ((ImageViewHolder) holder).image.loadImage(mImages[getImagePosition(position)].getCloudinaryUrl());
                break;
            case ViewType.VIDEO:
                if (mVideos != null) {
                    ((VideoViewHolder) holder).image.loadImage(mVideos[position].getThumbUrl());
                }
                break;

        }
    }

    @Override
    public int getItemCount() {
        return mVideos == null ? mImages.length : mImages.length + mVideos.length;
    }

    public void setOnImageClickListener(@Nullable OnImageClickListener onImageClickListener) {
        mOnImageClickListener = onImageClickListener;
    }

    public void setOnVideoClickListener(@Nullable OnVideoClickListener onVideoClickListener) {
        mOnVideoClickListener = onVideoClickListener;
    }

    private void onImageClicked(int position) {
        if (mOnImageClickListener != null) {
            mOnImageClickListener.onImageClick(mImages, position);
        }
    }

    private void onVideoClicked(int position) {
        if (mOnVideoClickListener != null && mVideos != null) {
            mOnVideoClickListener.onVideoClick(mVideos[position].getId());
        }
    }

    class ImageViewHolder extends TransitionViewHolder {

        @BindView(R.id.image_screenshot)
        WebImageView image;

        ImageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public Bundle getTransitionOptions(@NonNull Activity activity) {
            return new TransitionBuilder()
                    .add(image)
                    .build(activity);
        }

        @OnClick(R.id.view_click)
        void onImageClick() {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                onImageClicked(getImagePosition(position));
            }
        }

    }

    class VideoViewHolder extends TransitionViewHolder {

        @BindView(R.id.image_thumb)
        WebImageView image;

        VideoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public Bundle getTransitionOptions(@NonNull Activity activity) {
            return null;
        }

        @OnClick(R.id.view_click)
        void onVideoClick() {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                onVideoClicked(position);
            }
        }

    }


    public interface OnImageClickListener {
        void onImageClick(Image[] images, int position);
    }

    public interface OnVideoClickListener {
        void onVideoClick(String videoId);
    }

    public interface ViewType {
        int VIDEO = 0;
        int IMAGE = 1;
    }

}
