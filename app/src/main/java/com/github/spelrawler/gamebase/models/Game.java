package com.github.spelrawler.gamebase.models;

import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Created by Spel on 28.05.2017.
 */

public class Game {

    @Expose
    @SerializedName(Field.ID)
    private long mId;
    @Expose
    @SerializedName(Field.NAME)
    private String mName;
    @Expose
    @SerializedName(Field.COVER)
    private Image mCover;


    public long getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    @Nullable
    public Image getCover() {
        return mCover;
    }

    @Nullable
    public String getCoverUrl() {
        return mCover == null ? null : mCover.getCloudinaryUrl();
    }

    public interface Field {
        String ID = "id";
        String NAME = "name";
        String SLUG = "slug";
        String URL = "url";
        String CREATED_AT = "created_at";
        String UPDATED_AT = "updated_at";
        String SUMMARY = "summary";
        String STORYLINE = "storyline";
        String COLLECTION = "collection";
        String FRANCHISE = "franchise";
        String HYPES = "hypes";
        String RATING = "rating";
        String POPULARITY = "popularity";
        String AGGREGATED_RATING = "aggregated_rating";
        String RAITING_COUNT = "rating_count";
        String GAME = "game";
        String DEVELOPERS = "developers";
        String PUBLISHERS = "publishers";
        String GAME_ENGINES = "game_engines";
        String CATEGORY = "category";
        String TIME_TO_BEAT = "time_to_beat";
        String PLAYER_PRESPECTIVES = "player_perspectives";
        String GAME_MODES = "game_modes";
        String KEYWORDS = "keywords";
        String THEMES = "themes";
        String GENRES = "genres";
        String FIRST_RELEASE_DATE = "first_release_date";
        String STATUS = "status";
        String RELEASE_DATES = "release_dates";
        String ALTERNATIVE_NAMES = "alternative_names";
        String SCREENSHOTS = "screenshots";
        String VIDEOS = "videos";
        String COVER = "cover";
        String ESRB = "esrb";
        String PEGI = "pegi";
        String WEBSITES = "websites";
        String TAGS = "tags";
        String ALL = "*";
    }


}
