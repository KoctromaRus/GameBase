package com.github.spelrawler.gamebase.mvp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Spel on 28.05.2017.
 */

public class Name {

    @Expose
    @SerializedName(Field.NAME)
    private String mName;
    @Expose
    @SerializedName(Field.COMMENT)
    private String mComment;

    public interface Field {
        String NAME = "name";
        String COMMENT = "comment";
    }

}
