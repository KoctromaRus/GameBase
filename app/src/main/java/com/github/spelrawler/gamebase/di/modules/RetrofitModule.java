package com.github.spelrawler.gamebase.di.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Spel on 28.05.2017.
 */

@Module
public class RetrofitModule {

    private static final String BASE_URL = "https://igdbcom-internet-game-database-v1.p.mashape.com/";
    private static final String HEADER_API_KEY = "X-Mashape-Key";
    private static final String HEADER_ACCEPT = "Accept";
    private static final String API_KEY = "h33UyiSHBBmshS7Zy6tbbZeJBtt9p1sTCw4jsnFrhdNZF4OaXi";
    private static final String ACCEPT = "application/json";

    @Provides
    @Singleton
    public Retrofit provideRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return builder.baseUrl(BASE_URL).client(client).build();
    }

    @Provides
    @Singleton
    public Retrofit.Builder provideRetrofitBuilder(Converter.Factory converterFactory) {
        return new Retrofit.Builder().addConverterFactory(converterFactory);
    }

    @Provides
    @Singleton
    public Converter.Factory provideConverterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    @Provides
    @Singleton
    public Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Provides
    @Singleton
    public OkHttpClient provideClient(Interceptor interceptor) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);

        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(interceptor).build();
    }

    @Provides
    @Singleton
    public Interceptor provideInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        .addHeader(HEADER_API_KEY, API_KEY)
                        .addHeader(HEADER_ACCEPT, ACCEPT)
                        .build();

                return chain.proceed(request);
            }
        };
    }


}
