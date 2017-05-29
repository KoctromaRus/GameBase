package com.github.spelrawler.gamebase.api.models.queries;

import com.github.spelrawler.gamebase.api.models.Filter;
import com.github.spelrawler.gamebase.utils.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 * Created by Spel on 28.05.2017.
 */

public class BaseQuery extends HashMap<String, String> {

    private static final char COMA = ',';
    private static final String FORMAT_SORT = "%s:%s";

    protected BaseQuery() {

    }

    public void addFilters(List<Filter> filters) {
        for (Filter filter : filters) {
            addFilter(filter);
        }
    }

    public void addFilter(Filter filter) {
        put(filter.getFormattedKey(), filter.getValue());
    }

    protected void addFields(String... fields) {
        put(Key.FIELDS, StringUtils.listToString(fields));
    }

    public void setOffset(int offset) {
        put(Key.OFFSET, String.valueOf(offset));
    }

    public void setOrder(String field, String order) {
        put(Key.ORDER, String.format(Locale.getDefault(), FORMAT_SORT, field, order));
    }

    public interface Key {
        String FIELDS = "fields";
        String OFFSET = "offset";
        String ORDER = "order";
    }

    public interface Order {
        String DESC = "desc";
        String ASC = "asc";
    }

}
