package com.retrofitdemo.http.request;

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

    public void callApi(String userId, int page) {

    }
}
