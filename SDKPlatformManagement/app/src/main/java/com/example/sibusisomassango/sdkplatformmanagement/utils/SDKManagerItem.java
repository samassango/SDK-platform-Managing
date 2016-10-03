package com.example.sibusisomassango.sdkplatformmanagement.utils;

/**
 * Created by sibusisomassango on 2016/10/03.
 */
public class SDKManagerItem {
    private String sdktitle;
    private String sdkDate;
    public SDKManagerItem(){

    }

    public SDKManagerItem(String sdktitle) {
        this.sdktitle = sdktitle;
    }

    public SDKManagerItem(String sdktitle, String sdkDate) {
        this.sdktitle = sdktitle;
        this.sdkDate = sdkDate;
    }

    public String getSdkDate() {
        return sdkDate;
    }

    public void setSdkDate(String sdkDate) {
        this.sdkDate = sdkDate;
    }

    public String getSdktitle() {
        return sdktitle;
    }

    public void setSdktitle(String sdktitle) {
        this.sdktitle = sdktitle;
    }

}
