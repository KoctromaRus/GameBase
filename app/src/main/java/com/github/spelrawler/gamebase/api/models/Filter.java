package com.github.spelrawler.gamebase.api.models;

/**
 * Created by Spel on 28.05.2017.
 */

public class Filter {

    public static final String GENRES = "genres";

    private static final String OPEN_BRACKET = "[";
    private static final String CLOSE_BRACKET = "]";
    private static final String EQUAL = "=";
    private static final String FILTER = "filter";

    private String mKey;
    private String mPostfix;
    private String mValue;


    public Filter(String key, String postfix, int value) {
        this(key, postfix, String.valueOf(value));
    }

    public Filter(String key, String postfix, String value) {
        mKey = key;
        mPostfix = postfix;
        mValue = value;
    }

    public String getFormattedKey() {
        return wrapWithBrackets(mKey) + wrapWithBrackets(mPostfix);
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
        String QT = "gt";                   //Greater than works only on numbers.
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
