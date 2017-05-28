package com.github.spelrawler.gamebase.api.models.queries;

import com.github.spelrawler.gamebase.api.models.Filter;
import com.github.spelrawler.gamebase.models.Game;

import java.util.List;

/**
 * Created by Spel on 28.05.2017.
 */

public class GamesQuery extends BaseQuery {

    public static GamesQuery create(List<Filter> filters, String... fields) {
        GamesQuery query = new GamesQuery();
        for (Filter filter : filters) {
            query.addFilter(filter);
        }
        query.addFields(fields);

        return query;
    }

    public static GamesQuery create() {
        GamesQuery query = new GamesQuery();
        query.addFields(Game.Field.ALL);

        return query;
    }

    public static GamesQuery create(String... fields) {
        GamesQuery query = new GamesQuery();
        query.addFields(fields);

        return query;
    }

}
