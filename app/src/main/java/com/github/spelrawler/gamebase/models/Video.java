package com.github.spelrawler.gamebase.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Spel on 28.05.2017.
 */

public class Video {

    @Expose
    @SerializedName(Field.ID)
    private String mId;
    @Expose
    @SerializedName(Field.NAME)
    private String mName;

    public interface Field {
        String ID = "video_id";//Youtube id
        String NAME = "name";
    }

}
