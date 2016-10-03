package com.example.sibusisomassango.sdkplatformmanagement.utils;

import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sibusisomassango on 2016/10/03.
 */
public class ValidatePassword {
    private String password;

   public ValidatePassword(String password){
       this.password = password;
   }
    public boolean isValidPassword(){
        boolean isValidPassword =false;

       char[] passwordArray = new char[password.toCharArray().length];

        passwordArray = password.toCharArray();
        int digits = 0;
        int upperCase = 0;
        int lowerCase = 0;


        if(passwordArray.length>11) {
              for(char c:passwordArray){

                      if (Character.isDigit(c)) {
                          digits += 1;
                      } else {
                          if (Character.isUpperCase(c)) {
                              upperCase +=1;
                          } else {
                              if (Character.isLowerCase(c)) {
                                  lowerCase +=1;
                              }
                          }
                      }
              }
       }
        //check whether the password contain any special character
        Pattern pattern = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(password);
        boolean hasSpecialCharacter = matcher.find();

       //password require it's length to be 11 or more, should contain digits, uppercase, lowercase, and special character.
        if(hasSpecialCharacter && digits >0 && upperCase >0 && lowerCase >0 ){
            isValidPassword = true;
        }

        return isValidPassword;
    }
}
