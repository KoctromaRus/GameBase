package com.github.spelrawler.gamebase.models;

import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Locale;

/**
 * Created by Spel on 28.05.2017.
 */

public class Image implements Serializable {

    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 300;
    private static final String CLOUDINARY_URL_FORMAT = "http://res.cloudinary.com/igdb/image/upload/h_%d/%s.png";

    @Expose
    @SerializedName(Field.URL)
    private String mUrl;
    @Expose
    @SerializedName(Field.WIDTH)
    private int mWidth;
    @Expose
    @SerializedName(Field.HEIGHT)
    private int mHeight;
    @Expose
    @SerializedName(Field.CLOUDINARY_ID)
    private String mCloudinaryId;

    public int getWidth() {
        return mWidth;
    }

    public int getHeight() {
        return mHeight;
    }

    public String getCloudinaryId() {
        return mCloudinaryId;
    }

    @Nullable
    public String getCloudinaryUrl() {
        return getCloudinaryUrl(DEFAULT_HEIGHT);
    }

    @Nullable
    public String getCloudinaryUrl(int height) {
        if (mCloudinaryId == null) return null;
        return String.format(Locale.getDefault(), CLOUDINARY_URL_FORMAT, height, mCloudinaryId);
    }

    public interface Field {
        String URL = "url";
        String WIDTH = "width";
        String HEIGHT = "height";
        String CLOUDINARY_ID = "cloudinary_id";
    }

}
