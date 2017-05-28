package com.github.spelrawler.gamebase.ui.adapters;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.github.spelrawler.gamebase.models.Image;
import com.github.spelrawler.gamebase.ui.widgets.WebImageView;

/**
 * Created by Spel on 28.05.2017.
 */

public class ScreenshotsAdapter extends RecyclerView.Adapter<ScreenshotsAdapter.ViewHolder>  {

    private Image[] mImages;
    @Nullable
    private OnImageClickListener mOnImageClickListener;

    public ScreenshotsAdapter(@NonNull Image[] images) {
        mImages = images;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(new WebImageView(parent.getContext()));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.image.loadImage(mImages[position].getCloudinaryUrl());
    }

    @Override
    public int getItemCount() {
        return mImages.length;
    }

    public void setOnImageClickListener(@Nullable OnImageClickListener onImageClickListener) {
        mOnImageClickListener = onImageClickListener;
    }

    private void onImageClicked(View imageView, int position) {
        if (mOnImageClickListener != null) {
            mOnImageClickListener.onImageClick(imageView, mImages, position);
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private WebImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (WebImageView) itemView;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                onImageClicked(view, position);
            }
        }
    }

    public interface OnImageClickListener {
        void onImageClick(View imageView, Image[] images, int position);
    }

}
