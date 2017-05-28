package com.github.spelrawler.gamebase.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Spel on 28.05.2017.
 */

public class WebSite {

    @Expose
    @SerializedName(Field.CATEGORY)
    private long mCategory;
    @Expose
    @SerializedName(Field.URL)
    private String mUrl;

    public interface Field {
        String CATEGORY = "category";
        String URL = "url";
    }

}
