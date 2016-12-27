package com.retrofitdemo.http.apiInterface;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by tarun on 27/12/16.
 */

public interface MainActivityApiInterface {
    @FormUrlEncoded
    @POST("userapi/pages")
    Call<ResponseBody> vendors(@Field("page") String page, @Field("userId") String userId);
}
