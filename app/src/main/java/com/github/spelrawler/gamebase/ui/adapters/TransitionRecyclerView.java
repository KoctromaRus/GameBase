package com.github.spelrawler.gamebase.ui.adapters;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.github.spelrawler.gamebase.ui.widgets.TransitionViewHolder;

/**
 * Created by Spel on 30.05.2017.
 */

public class TransitionRecyclerView extends RecyclerView {

    public TransitionRecyclerView(Context context) {
        super(context);
    }

    public TransitionRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TransitionRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public Bundle createTransitionBundleForItemId(@NonNull Activity activity, long id) {
        try {
            return ((TransitionViewHolder) findViewHolderForItemId(id))
                    .getTransitionOptions(activity);
        } catch (ClassCastException e) {
            throw new IllegalStateException("TransitionRecyclerView supports only TransitionViewHolder");
        }
    }

    public Bundle createTransitionBundleForPosition(@NonNull Activity activity, int position) {
        try {
            return ((TransitionViewHolder) findViewHolderForAdapterPosition(position))
                    .getTransitionOptions(activity);
        } catch (ClassCastException e) {
            throw new IllegalStateException("TransitionRecyclerView supports only TransitionViewHolder");
        }
    }

}
