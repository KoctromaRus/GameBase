package com.github.spelrawler.gamebase.mvp;

import com.github.spelrawler.gamebase.api.GamesApi;
import com.github.spelrawler.gamebase.api.models.queries.GamesQuery;
import com.github.spelrawler.gamebase.models.Game;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Spel on 28.05.2017.
 */

public class IgdbService {

    private GamesApi mGamesApi;

    public IgdbService(GamesApi gamesApi) {
        mGamesApi = gamesApi;
    }

    public void getGames(Callback<List<Game>> callback) {
        mGamesApi.getGames(GamesQuery.create()).enqueue(new CallbackConverter<>(callback));
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

    public interface Callback<T> {
        void onDataFetched(T t);
        void onError(String message);
    }




}
