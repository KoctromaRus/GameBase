package com.github.spelrawler.gamebase.ui.widgets;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Spel on 30.05.2017.
 */

public abstract class TransitionViewHolder extends RecyclerView.ViewHolder {

    public TransitionViewHolder(View itemView) {
        super(itemView);
    }

    public abstract Bundle getTransitionOptions(@NonNull Activity activity);

}
