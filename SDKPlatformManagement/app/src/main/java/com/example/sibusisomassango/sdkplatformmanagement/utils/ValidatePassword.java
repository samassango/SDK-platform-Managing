package com.example.sibusisomassango.sdkplatformmanagement.utils;

/**
 * Created by sibusisomassango on 2016/10/01.
 */
public class ValidatePassword {
    private String password;

   public ValidatePassword(String password){
       this.password = password;
   }
    public boolean isValidPassword(){
        boolean isValidPassword =false;

       char[] passwordArray = new char[password.toCharArray().length];

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

        if(password.matches("[^A-Za-z0-9 ]") & digits >0 && upperCase >0 && lowerCase >0 ){
            isValidPassword = true;
        }

        return isValidPassword;
    }
}
