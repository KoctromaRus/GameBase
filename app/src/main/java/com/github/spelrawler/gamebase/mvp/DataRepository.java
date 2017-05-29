package com.github.spelrawler.gamebase.mvp;

import com.github.spelrawler.gamebase.api.models.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Spel on 30.05.2017.
 */

public class DataRepository {

    private List<Filter> mFilters = new ArrayList<>();

    public void setTestFilters() {
        mFilters = new ArrayList<>();
        mFilters.add(Filter.createGenres(2, 12));
        mFilters.add(Filter.createMinRating(80));
    }

    public void updateFilters(List<Filter> filters) {
        mFilters = filters;
    }

    public List<Filter> getFilters() {
        return mFilters;
    }


}
