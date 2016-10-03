package com.example.sibusisomassango.sdkplatformmanagement.utils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sibusisomassango on 2016/10/01.
 */
public class ValidateEmail {
    private String emailAddress;
    private boolean isValidEmail = false;

    public ValidateEmail(String email){
        this.emailAddress = email;
    }

    public boolean validateEmailAddress(){

        String strPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(emailAddress.matches(strPattern)){
            isValidEmail = true;
        }

        return isValidEmail;
    }

}
