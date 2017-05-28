package com.github.spelrawler.gamebase.mvp;

import android.support.annotation.Nullable;

import com.github.spelrawler.gamebase.api.CompaniesApi;
import com.github.spelrawler.gamebase.api.GamesApi;
import com.github.spelrawler.gamebase.api.models.queries.CompaniesQuery;
import com.github.spelrawler.gamebase.api.models.queries.GamesQuery;
import com.github.spelrawler.gamebase.mvp.models.Company;
import com.github.spelrawler.gamebase.mvp.models.Game;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Spel on 28.05.2017.
 */

public class IgdbService {

    private GamesApi mGamesApi;
    private CompaniesApi mCompaniesApi;

    public IgdbService(GamesApi gamesApi, CompaniesApi companiesApi) {
        mGamesApi = gamesApi;
        mCompaniesApi = companiesApi;
    }

    public void getGames(Callback<List<Game>> callback) {
        getGames(GamesQuery.create(Game.Field.NAME, Game.Field.SUMMARY, Game.Field.ID, Game.Field.COVER, Game.Field.RATING), callback);
    }

    public void getGames(int offset, Callback<List<Game>> callback) {
        GamesQuery query = GamesQuery.create(Game.Field.NAME, Game.Field.SUMMARY, Game.Field.ID, Game.Field.COVER, Game.Field.RATING);
        query.setOffset(offset);
        getGames(query, callback);
    }

    public void getGames(GamesQuery query, Callback<List<Game>> callback) {
        mGamesApi.getGames(query).enqueue(new CallbackConverter<>(callback));
    }

    public void getGame(long id, GamesQuery query, Callback<Game> callback) {
        mGamesApi.getGame(id, query).enqueue(new CallbackListToObjectConverter<>(callback));
    }

    public void getGame(long id, Callback<Game> callback) {
        getGame(id, GamesQuery.create(), callback);
    }

    public void getCompany(long id, Callback<Company> callback) {
        CompaniesQuery query = CompaniesQuery.create();
        getCompany(id, query, callback);
    }

    public void getCompany(long id, CompaniesQuery query, Callback<Company> callback) {
        mCompaniesApi.getCompany(id, query).enqueue(new CallbackListToObjectConverter<>(callback));
    }

    public class CallbackConverter<T> implements retrofit2.Callback<T> {

        private Callback<T> mCallback;

        public CallbackConverter(Callback<T> callback) {
            mCallback = callback;
        }

        @Override
        public void onResponse(Call<T> call, Response<T> response) {
            if (response.errorBody() == null) {
                mCallback.onDataFetched(response.body());
            } else {
                mCallback.onError(response.errorBody().toString());
            }
        }

        @Override
        public void onFailure(Call<T> call, Throwable t) {
            mCallback.onError(t.getMessage());
        }
    }

    public class CallbackListToObjectConverter<T> implements retrofit2.Callback<List<T>> {

        private Callback<T> mCallback;

        public CallbackListToObjectConverter(Callback<T> callback) {
            mCallback = callback;
        }

        @Override
        public void onResponse(Call<List<T>> call, Response<List<T>> response) {
            if (response.errorBody() != null) {
                mCallback.onError(response.errorBody().toString());
            }
            List<T> objects = response.body();
            if (objects == null || objects.isEmpty()) {
                mCallback.onError(null);
            } else {
                mCallback.onDataFetched(objects.get(0));
            }
        }

        @Override
        public void onFailure(Call<List<T>> call, Throwable t) {
            mCallback.onError(t.getMessage());
        }
    }

    public interface Callback<T> {
        void onDataFetched(T t);
        void onError(@Nullable String message);
    }




}
