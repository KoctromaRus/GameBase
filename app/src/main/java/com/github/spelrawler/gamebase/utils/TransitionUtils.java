package com.github.spelrawler.gamebase.utils;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.View;
import android.view.Window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Spel on 28.05.2017.
 */

public class TransitionUtils {

    public static Bundle createSingleSharedElementOptions(Activity activity, View view, String transitionName) {
        return createSingleSharedElementOptions(activity, Pair.create(view, transitionName));
    }


    @SafeVarargs
    public static Bundle createSingleSharedElementOptions(Activity activity, Pair<View, String>... pairs) {

        View statusBarBackground = activity.findViewById(android.R.id.statusBarBackground);
        View navigationBar = activity.findViewById(android.R.id.navigationBarBackground);

        List<Pair<View, String>> list = new ArrayList<>();

        if (navigationBar != null){
            list.add(Pair.create(navigationBar, Window.NAVIGATION_BAR_BACKGROUND_TRANSITION_NAME));
        }
        if (statusBarBackground != null) {
            list.add(Pair.create(statusBarBackground, Window.STATUS_BAR_BACKGROUND_TRANSITION_NAME));
        }

        list.addAll(Arrays.asList(pairs));

        @SuppressWarnings("unchecked")
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(activity, list.toArray(new Pair[0]));

        return options.toBundle();
    }

}
