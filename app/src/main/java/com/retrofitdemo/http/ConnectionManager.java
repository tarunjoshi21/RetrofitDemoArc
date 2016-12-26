package com.retrofitdemo.http;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tarun on 23/12/16.
 */
public class ConnectionManager {
    private static ConnectionManager ourInstance = new ConnectionManager();

    public static ConnectionManager getInstance() {
        return ourInstance;
    }

    private ConnectionManager() {
    }

    public void initiateCall(Call<ResponseBody> call, final OnWebServiceCompleteListener onWebServiceCompleteListener) {
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    onWebServiceCompleteListener.onWebServiceComplete(response.body());
                }else{
                    //APIError error = ErrorUtils.parseError(response);
                    onWebServiceCompleteListener.onWebStatusFalse(response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                onWebServiceCompleteListener.onWebStatusFalse(t.getMessage());
            }
        });
    }
}
