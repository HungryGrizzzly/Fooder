package com.application.fooder.fooder.MethodsLibrary;

public class MyUtils {

    public static boolean isPasswordToSmall(String password){
        if(password.length() <6){
            return false;
        }
        else {
            return true;
        }
    }

    public static boolean isStringEmpty(String string){
        if(string.length() > 0){
            return true;
        }
        else {
            return false;
        }
    }
}
