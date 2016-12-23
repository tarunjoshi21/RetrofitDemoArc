package com.retrofitdemo.http;

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

    public void initiateCall() {

    }
}
