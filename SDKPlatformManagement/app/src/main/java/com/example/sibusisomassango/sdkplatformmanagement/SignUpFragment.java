package com.example.sibusisomassango.sdkplatformmanagement;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by sibusisomassango on 2016/10/03.
 */
public class SignUpFragment extends android.support.v4.app.Fragment{
    public SignUpFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.signup_fragment, null);

        ViewHolder holder = new ViewHolder();

        holder.webView = (WebView) v.findViewById(R.id.webView);

        holder.webView.loadUrl("https://www.android.com/");

        return v;
    }
    public static class ViewHolder{
        private WebView webView;
    }
}
