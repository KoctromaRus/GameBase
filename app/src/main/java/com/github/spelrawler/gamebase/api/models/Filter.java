package com.github.spelrawler.gamebase.api.models;

import com.github.spelrawler.gamebase.utils.StringUtils;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Spel on 28.05.2017.
 */

public class Filter implements Serializable {

    public static final String GENRES = "genres";
    public static final String RELEASE_DATE = "first_release_date";
    public static final String RATING = "rating";

    private static final String OPEN_BRACKET = "[";
    private static final String CLOSE_BRACKET = "]";
    private static final String EQUAL = "=";
    private static final String FILTER = "filter";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

    private String mKey;
    private String mPostfix;
    private String mValue;


    public static Filter createGenres(int... genreIds) {
        return new Filter(GENRES, Postfix.ANY, StringUtils.listToString(genreIds));
    }

    public static Filter createMinRating(int rating) {
        return new Filter(RATING, Postfix.GT, rating);
    }

    public static Filter createMaxRating(int rating) {
        return new Filter(RATING, Postfix.LT, rating);
    }

    public static Filter createStartDate(Date date) {
        return new Filter(RELEASE_DATE, Postfix.GT, DATE_FORMAT.format(date));
    }

    public static Filter createEndDate(Date date) {
        return new Filter(RELEASE_DATE, Postfix.LT, DATE_FORMAT.format(date));
    }

    public Filter(String key, String postfix, int value) {
        this(key, postfix, String.valueOf(value));
    }

    public Filter(String key, String postfix, long value) {
        this(key, postfix, String.valueOf(value));
    }

    public Filter(String key, String postfix, String value) {
        mKey = key;
        mPostfix = postfix;
        mValue = value;
    }

    public String getFormattedKey() {
        return FILTER + wrapWithBrackets(mKey) + wrapWithBrackets(mPostfix);
    }

    public String getValue() {
        return mValue;
    }

    private String wrapWithBrackets(String text) {
        return OPEN_BRACKET + text + CLOSE_BRACKET;
    }

    public interface Postfix {

        String EQ = "eq";                   //Equal: Exact match equal.
        String NOT_EQ = "not_eq";           //Not Equal: Exact match equal.
        String GT = "gt";                   //Greater than works only on numbers.
        String GTE = "gte";                 //Greater than or equal to works only on numbers.
        String LT = "lt";                   //Less than works only on numbers.
        String LTE = "lte";                 //Less than or equal to works only on numbers.
        String PREFIX = "prefix";           //Prefix of a value only works on strings.
        String EXISTS = "exists";           //The value is not null.
        String NOT_EXISTS = "not_exists";   //The value is null.
        String IN = "in";                   //The value exists within the (comma separated) array (AND between values).
        String NOT_IN = "not_in";           //The values must not exists within the (comma separated) array (AND between values).
        String ANY = "any";                 //The value has any within the (comma separated) array (OR between values).

    }

}
