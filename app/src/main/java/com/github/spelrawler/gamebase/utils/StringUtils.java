package com.github.spelrawler.gamebase.utils;

/**
 * Created by Spel on 29.05.2017.
 */

public class StringUtils {

    private static final char COMA = ',';

    public static String listToString(int... list) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.length - 1; i++) {
            builder.append(list[i]);
            builder.append(COMA);
        }
        builder.append(list[list.length - 1]);

        return builder.toString();
    }

    public static String listToString(String... list) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.length - 1; i++) {
            builder.append(list[i]);
            builder.append(COMA);
        }
        builder.append(list[list.length - 1]);

        return builder.toString();
    }

}
