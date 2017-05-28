package com.github.spelrawler.gamebase.api.models.queries;

import com.github.spelrawler.gamebase.api.models.Filter;

import java.util.HashMap;

/**
 * Created by Spel on 28.05.2017.
 */

public class BaseQuery extends HashMap<String, String> {

    private static final char COMA = ',';

    protected BaseQuery() {

    }

    protected void addFilter(Filter filter) {
        put(filter.getFormattedKey(), filter.getValue());
    }

    protected void addFields(String... fields) {
        put(Key.FIELDS, listToString(fields));
    }

    protected static String listToString(int... list) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.length - 1; i++) {
            builder.append(list[i]);
            builder.append(COMA);
        }
        builder.append(list[list.length - 1]);

        return builder.toString();
    }

    protected static String listToString(String... list) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.length - 1; i++) {
            builder.append(list[i]);
            builder.append(COMA);
        }
        builder.append(list[list.length - 1]);

        return builder.toString();
    }

    public void setOffset(int offset) {
        put(Key.OFFSET, String.valueOf(offset));
    }

    public interface Key {
        String FIELDS = "fields";
        String OFFSET = "offset";
    }

}
