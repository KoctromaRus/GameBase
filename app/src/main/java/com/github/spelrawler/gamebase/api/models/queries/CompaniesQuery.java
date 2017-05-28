package com.github.spelrawler.gamebase.api.models.queries;

import com.github.spelrawler.gamebase.mvp.models.Company;

/**
 * Created by Spel on 28.05.2017.
 */

public class CompaniesQuery extends BaseQuery {

    public static CompaniesQuery create() {
        CompaniesQuery query = new CompaniesQuery();
        query.addFields(Company.Field.ALL);

        return query;
    }

}
