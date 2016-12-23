package com.retrofitdemo.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by tarun on 23/12/16.
 */

public class ApiClient {
    private static ApiClient apiBuilder;
    private Retrofit retrofit = null;
    private OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private Retrofit.Builder builder = null;
    private int TIME_OUT = 45;

    private ApiClient() {}

    /**
     * Factory method of {@link ApiClient}
     * @return instance of {@link ApiClient}
     */
    public static ApiClient getInstance() {
        if (apiBuilder == null) {
            apiBuilder = new ApiClient();
        }
        return apiBuilder;
    }

    /**
     *
     * @return instance of {@link retrofit2.Retrofit.Builder}
     */
    private Retrofit.Builder getRetrofitBuilder() {
        if (builder == null) {
            builder = new Retrofit.Builder().baseUrl(ServerUrl.BASE_URL)
                    .client(httpClient.connectTimeout(TIME_OUT, TimeUnit.SECONDS).readTimeout(TIME_OUT,TimeUnit.SECONDS).build());
                   /* .addConverterFactory(GsonConverterFactory.create());*/

        }
        return builder;
    }

    /**
     *
     * @param serviceClass
     * @param <S>
     * @return
     */
    public <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }

    public  Retrofit getClient() {
        if (retrofit==null) {
            retrofit = getRetrofitBuilder()
                    .build();
        }
        return retrofit;
    }

}
