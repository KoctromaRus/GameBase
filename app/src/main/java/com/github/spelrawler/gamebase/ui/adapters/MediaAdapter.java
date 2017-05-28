package com.github.spelrawler.gamebase.ui.adapters;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.spelrawler.gamebase.R;
import com.github.spelrawler.gamebase.mvp.models.Image;
import com.github.spelrawler.gamebase.mvp.models.Video;
import com.github.spelrawler.gamebase.ui.widgets.WebImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Spel on 28.05.2017.
 */

public class MediaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    private Image[] mImages;
    @Nullable
    private Video[] mVideos;
    @Nullable
    private OnImageClickListener mOnImageClickListener;
    @Nullable
    private OnVideoClickListener mOnVideoClickListener;

    public MediaAdapter(@Nullable Video[] videos, @NonNull Image[] images) {
        mImages = images;
        mVideos = videos;
    }

    @Override
    public int getItemViewType(int position) {
        if (mVideos == null) return ViewType.IMAGE;
        return position < mVideos.length ? ViewType.VIDEO : ViewType.IMAGE;
    }

    private int getImagePosition(int position) {
        return position - (mVideos == null ? 0 : mVideos.length);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
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
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
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

    private void onImageClicked(View imageView, int position) {
        if (mOnImageClickListener != null) {
            mOnImageClickListener.onImageClick(imageView, mImages, position);
        }
    }

    private void onVideoClicked(int position) {
        if (mOnVideoClickListener != null && mVideos != null) {
            mOnVideoClickListener.onVideoClick(mVideos[position].getId());
        }
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image_screenshot)
        WebImageView image;

        public ImageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.view_click)
        public void onImageClick() {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                onImageClicked(image, getImagePosition(position));
            }
        }

    }

    class VideoViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image_thumb)
        WebImageView image;

        public VideoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
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
        void onImageClick(View imageView, Image[] images, int position);
    }

    public interface OnVideoClickListener {
        void onVideoClick(String videoId);
    }

    public interface ViewType {
        int VIDEO = 0;
        int IMAGE = 1;
    }

}
