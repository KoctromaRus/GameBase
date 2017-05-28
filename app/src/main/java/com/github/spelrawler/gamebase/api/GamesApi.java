package com.github.spelrawler.gamebase.api;

import com.github.spelrawler.gamebase.api.models.queries.GamesQuery;
import com.github.spelrawler.gamebase.models.Game;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by Spel on 28.05.2017.
 */

public interface GamesApi {

    @GET("games/")
    Call<List<Game>> getGames(@QueryMap GamesQuery query);

    @GET("games/{id}/")
    Call<List<Game>> getGame(@Path("id") long id, @QueryMap GamesQuery query);

}
