package com.github.spelrawler.gamebase.api;

import com.github.spelrawler.gamebase.api.models.queries.CompaniesQuery;
import com.github.spelrawler.gamebase.mvp.models.Company;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by Spel on 28.05.2017.
 */

public interface CompaniesApi {

    @GET("companies/{id}")
    Call<List<Company>> getCompany(@Path("id") long id, @QueryMap CompaniesQuery query);

}
