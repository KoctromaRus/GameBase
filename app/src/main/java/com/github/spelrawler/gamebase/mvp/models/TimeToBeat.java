package com.github.spelrawler.gamebase.mvp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Spel on 28.05.2017.
 */

public class TimeToBeat {

    @Expose
    @SerializedName(Field.HASTLY)
    private long mHastly;
    @Expose
    @SerializedName(Field.NORMALLY)
    private long mNormally;
    @Expose
    @SerializedName(Field.COMPLETELY)
    private long mCompletely;

    public long getHastly() {
        return mHastly;
    }

    public long getNormally() {
        return mNormally;
    }

    public long getCompletely() {
        return mCompletely;
    }

    public interface Field {
        String HASTLY = "hastly";
        String NORMALLY = "normally";
        String COMPLETELY = "completely";
    }

}
