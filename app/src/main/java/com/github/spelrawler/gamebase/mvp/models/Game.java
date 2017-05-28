package com.github.spelrawler.gamebase.mvp.models;

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
    @SerializedName(Field.SLUG)
    private String mSlug;
    @Expose
    @SerializedName(Field.URL)
    private String mUrl;
    @Expose
    @SerializedName(Field.CREATED_AT)
    private long mCreatedDate;
    @Expose
    @SerializedName(Field.UPDATED_AT)
    private long mUpdatedDate;
    @Expose
    @SerializedName(Field.SUMMARY)
    private String mSummary ;
    @Expose
    @SerializedName(Field.STORYLINE)
    private String mStoryline;
    @Expose
    @SerializedName(Field.COLLECTION)
    private long mCollection;
    @Expose
    @SerializedName(Field.FRANCHISE)
    private long mFranchise;
    @Expose
    @SerializedName(Field.HYPES)
    private int mHypes;
    @Expose
    @SerializedName(Field.RATING)
    private double mRating;
    @Expose
    @SerializedName(Field.GAME)
    private long mGameId;//ID of a Game record if this record is a DLC/expansion
    @Expose
    @SerializedName(Field.DEVELOPERS)
    private long[] mDevelopers;
    @Expose
    @SerializedName(Field.PUBLISHERS)
    private long[] mPublishers;
    @Expose
    @SerializedName(Field.GAME_ENGINES)
    private long[] mGameEngines;
    @Expose
    @SerializedName(Field.CATEGORY)
    private int mCategory;
    @Expose
    @SerializedName(Field.TIME_TO_BEAT)
    private TimeToBeat mTimeToBeat;
    @Expose
    @SerializedName(Field.PLAYER_PRESPECTIVES)
    private long[] mPlayerPerspectives;
    @Expose
    @SerializedName(Field.GAME_MODES)
    private long[] mGameModes;
    @Expose
    @SerializedName(Field.KEYWORDS)
    private long[] mKeywords;
    @Expose
    @SerializedName(Field.THEMES)
    private long[] mThemes;
    @Expose
    @SerializedName(Field.GENRES)
    private long[] mGenres;
    @Expose
    @SerializedName(Field.FIRST_RELEASE_DATE)
    private long mFirstReleaseDate;
    @Expose
    @SerializedName(Field.STATUS)
    private int mStatus;
    @Expose
    @SerializedName(Field.RELEASE_DATES)
    private ReleaseDate[] mReleaseDates;
    @Expose
    @SerializedName(Field.ALTERNATIVE_NAMES)
    private Name[] mAlternativeNames;
    @Expose
    @SerializedName(Field.SCREENSHOTS)
    private Image[] mScreenshots;
    @Expose
    @SerializedName(Field.VIDEOS)
    private Video[] mVideos;
    @Expose
    @SerializedName(Field.COVER)
    private Image mCover;
    @Expose
    @SerializedName(Field.ESRB)
    private AgeRating mEsrb;
    @Expose
    @SerializedName(Field.PEGI)
    private AgeRating mPegi;
    @Expose
    @SerializedName(Field.WEBSITES)
    private WebSite[] mWebsites;
    @Expose
    @SerializedName(Field.TAGS)
    private int[] mTags;


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

    public String getSlug() {
        return mSlug;
    }

    public String getUrl() {
        return mUrl;
    }

    public long getCreatedDate() {
        return mCreatedDate;
    }

    public long getUpdatedDate() {
        return mUpdatedDate;
    }

    public String getSummary() {
        return mSummary;
    }

    public String getStoryline() {
        return mStoryline;
    }

    public long getCollection() {
        return mCollection;
    }

    public long getFranchise() {
        return mFranchise;
    }

    public int getHypes() {
        return mHypes;
    }

    public double getRating() {
        return mRating;
    }

    public long getGameId() {
        return mGameId;
    }

    public long[] getDevelopers() {
        return mDevelopers;
    }

    public long[] getPublishers() {
        return mPublishers;
    }

    public long[] getGameEngines() {
        return mGameEngines;
    }

    public int getCategory() {
        return mCategory;
    }

    public TimeToBeat getTimeToBeat() {
        return mTimeToBeat;
    }

    public long[] getPlayerPerspectives() {
        return mPlayerPerspectives;
    }

    public long[] getGameModes() {
        return mGameModes;
    }

    public long[] getKeywords() {
        return mKeywords;
    }

    public long[] getThemes() {
        return mThemes;
    }

    public long[] getGenres() {
        return mGenres;
    }

    public long getFirstReleaseDate() {
        return mFirstReleaseDate;
    }

    public int getStatus() {
        return mStatus;
    }

    public ReleaseDate[] getReleaseDates() {
        return mReleaseDates;
    }

    public Name[] getAlternativeNames() {
        return mAlternativeNames;
    }

    public Image[] getScreenshots() {
        return mScreenshots;
    }

    public Video[] getVideos() {
        return mVideos;
    }

    public AgeRating getEsrb() {
        return mEsrb;
    }

    public AgeRating getPegi() {
        return mPegi;
    }

    public WebSite[] getWebsites() {
        return mWebsites;
    }

    public int[] getTags() {
        return mTags;
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
