package com.github.spelrawler.gamebase.mvp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Locale;

/**
 * Created by Spel on 28.05.2017.
 */

public class Video {

    private static final String THUMB_URL_FORMAT = "https://img.youtube.com/vi/%s/0.jpg";

    @Expose
    @SerializedName(Field.ID)
    private String mId;
    @Expose
    @SerializedName(Field.NAME)
    private String mName;

    public String getId() {
        return mId;
    }

    public String getThumbUrl() {
        return String.format(Locale.getDefault(), THUMB_URL_FORMAT, mId);
    }

    public interface Field {
        String ID = "video_id";//Youtube id
        String NAME = "name";
    }

}
