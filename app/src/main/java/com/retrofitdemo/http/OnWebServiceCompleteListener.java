package com.retrofitdemo.http;

import com.retrofitdemo.bean.BaseBean;

/**
 * Created by tarun on 23/12/16.
 */

public interface OnWebServiceCompleteListener {

    void onWebServiceComplete(BaseBean baseObject, int statusCode);

    void onWebServiceError(Exception exception, int statusCode);

    // this method will fired when service status is false
    void onWebStatusFalse(String message);


}
