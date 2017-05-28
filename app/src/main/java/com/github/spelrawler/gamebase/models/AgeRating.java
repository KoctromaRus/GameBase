package com.github.spelrawler.gamebase.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Spel on 28.05.2017.
 */

public class AgeRating {

    @Expose
    @SerializedName(Field.RATING)
    private int mRating;
    @Expose
    @SerializedName(Field.SYNOPSIS)
    private String mSynopsis;

    public interface Field {
        String RATING = "rating";
        String SYNOPSIS = "synopsis";
    }

}
