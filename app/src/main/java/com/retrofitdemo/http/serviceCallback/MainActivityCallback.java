package com.retrofitdemo.http.serviceCallback;

import com.retrofitdemo.bean.BaseBean;

/**
 * Created by tarun on 26/12/16.
 */

public interface MainActivityCallback {
    void onSuccess(BaseBean baseBean);
    void onError(String error);
}
