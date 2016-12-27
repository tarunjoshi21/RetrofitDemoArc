package com.retrofitdemo.bean;

/**
 * Created by sombirbisht on 5/5/16.
 */

public class VendorBean {
    private String status;
    private String status_message;

    /*public ArrayList<PagesDataList> getData() {
        return data;
    }

    public void setData(ArrayList<PagesDataList> data) {
        this.data = data;
    }*/

    public String getStatus_message() {
        return status_message;
    }

    public void setStatus_message(String status_message) {
        this.status_message = status_message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   /* private ArrayList<PagesDataList> data;*/
}
