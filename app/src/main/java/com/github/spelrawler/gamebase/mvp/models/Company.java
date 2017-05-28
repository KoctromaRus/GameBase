package com.github.spelrawler.gamebase.mvp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Spel on 28.05.2017.
 */

public class Company {

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
    private long mCreatedAt;
    @Expose
    @SerializedName(Field.UPLOADED_AT)
    private long mUploadedAt;
    @Expose
    @SerializedName(Field.LOGO)
    private Image mLogo;
    @Expose
    @SerializedName(Field.DESCRIPTION)
    private String mDescription;
    @Expose
    @SerializedName(Field.COUNTRY)
    private int mCountry;
    @Expose
    @SerializedName(Field.WEBSITE)
    private String mWebsite;
    @Expose
    @SerializedName(Field.START_DATE)
    private long mStartDate;
    @Expose
    @SerializedName(Field.START_DATE_CATEGORY)
    private int mStartDateCategory;
    @Expose
    @SerializedName(Field.CHANGED_COMPANY_ID)
    private long mChangedCompanyId;
    @Expose
    @SerializedName(Field.CHANGE_DATE)
    private long mChangeDate;
    @Expose
    @SerializedName(Field.CHANGE_DATE_CATEGORY)
    private int mChangeDateCategory;
    @Expose
    @SerializedName(Field.TWITTER)
    private String mTwitter;
    @Expose
    @SerializedName(Field.PUBLISHED)
    private long[] mPublished;
    @Expose
    @SerializedName(Field.DEVELOPED)
    private long[] mDeveloped;

    public long getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getSlug() {
        return mSlug;
    }

    public String getUrl() {
        return mUrl;
    }

    public long getCreatedAt() {
        return mCreatedAt;
    }

    public long getUploadedAt() {
        return mUploadedAt;
    }

    public Image getLogo() {
        return mLogo;
    }

    public String getDescription() {
        return mDescription;
    }

    public int getCountry() {
        return mCountry;
    }

    public String getWebsite() {
        return mWebsite;
    }

    public long getStartDate() {
        return mStartDate;
    }

    public int getStartDateCategory() {
        return mStartDateCategory;
    }

    public long getChangedCompanyId() {
        return mChangedCompanyId;
    }

    public long getChangeDate() {
        return mChangeDate;
    }

    public int getChangeDateCategory() {
        return mChangeDateCategory;
    }

    public String getTwitter() {
        return mTwitter;
    }

    public long[] getPublished() {
        return mPublished;
    }

    public long[] getDeveloped() {
        return mDeveloped;
    }

    public interface Field {
        String ID = "id";
        String NAME = "name";
        String SLUG = "slug";
        String URL = "url";
        String CREATED_AT = "created_at";
        String UPLOADED_AT = "updated_at";
        String LOGO = "logo";
        String DESCRIPTION = "description";
        String COUNTRY = "country";
        String WEBSITE = "website";
        String START_DATE = "start_date";
        String START_DATE_CATEGORY = "start_date_category";
        String CHANGED_COMPANY_ID = "changed_company_id";
        String CHANGE_DATE = "change_date";
        String CHANGE_DATE_CATEGORY = "change_date_category";
        String TWITTER = "twitter";
        String PUBLISHED = "published";
        String DEVELOPED = "developed";
        String ALL = "*";
    }

}
