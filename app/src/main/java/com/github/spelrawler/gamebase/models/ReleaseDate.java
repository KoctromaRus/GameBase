package com.github.spelrawler.gamebase.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Spel on 28.05.2017.
 */

public class ReleaseDate {

    @Expose
    @SerializedName(Field.ID)
    private long mId;

    public interface Field {
        String ID = "id";
    }

}
