package com.github.spelrawler.gamebase.utils;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.View;

/**
 * Created by Spel on 28.05.2017.
 */

public class TransitionUtils {

    public static Bundle createSingleSharedElementOptions(Activity activity, View view, String transitionName) {
        return createSingleSharedElementOptions(activity, Pair.create(view, transitionName));
    }


    @SafeVarargs
    public static Bundle createSingleSharedElementOptions(Activity activity, Pair<View, String>... pairs) {
        return ActivityOptionsCompat.makeSceneTransitionAnimation(activity, pairs).toBundle();
    }

}
