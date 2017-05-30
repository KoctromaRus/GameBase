package com.github.spelrawler.gamebase.mvp.models;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Spel on 30.05.2017.
 */

public class TransitionBuilder {

    private List<Pair<View, String>> mPairs = new ArrayList<>();

    public TransitionBuilder add(View view, String tag) {
        mPairs.add(Pair.create(view, tag));
        return this;
    }

    @SuppressWarnings("unchecked")
    public Bundle build(Activity activity) {
        return ActivityOptionsCompat.makeSceneTransitionAnimation(activity, mPairs.toArray(new Pair[0])).toBundle();
    }

}
