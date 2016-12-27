package com.retrofitdemo.http.request;

import android.util.Log;

import com.google.gson.Gson;
import com.retrofitdemo.bean.BaseBean;
import com.retrofitdemo.http.ApiClient;
import com.retrofitdemo.http.ConnectionManager;
import com.retrofitdemo.http.OnWebServiceCompleteListener;
import com.retrofitdemo.http.apiInterface.MainActivityApiInterface;
import com.retrofitdemo.http.serviceCallback.MainActivityCallback;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * Created by tarun on 26/12/16.
 */
public class MainActivityRequest {
    private static MainActivityRequest ourInstance = new MainActivityRequest();

    public static MainActivityRequest getInstance() {
        return ourInstance;
    }

    private MainActivityRequest() {
    }

    public void callApi(String userId, int page, final MainActivityCallback mainActivityCallback) {
        ApiClient apiClient = ApiClient.getInstance();
        Call<ResponseBody> responseBodyCall = apiClient.createService(MainActivityApiInterface.class).vendors(page+"", userId);
       ConnectionManager connectionManager = ConnectionManager.getInstance();
        connectionManager.initiateCall(responseBodyCall, new OnWebServiceCompleteListener() {
            @Override
            public void onWebServiceComplete(ResponseBody baseObject) {
                try {
                    Log.i("Response: ", baseObject.string());
                    Gson gson = new Gson();
                    BaseBean baseBean = gson.fromJson(baseObject.string(), BaseBean.class);
                    mainActivityCallback.onSuccess(baseBean);
                } catch (IOException e) {
                    e.printStackTrace();
                    mainActivityCallback.onError(e.getMessage());
                }
            }

            @Override
            public void onWebStatusFalse(String message) {
                Log.e("Error: ", message);
                mainActivityCallback.onError(message);
            }
        });
    }



}
