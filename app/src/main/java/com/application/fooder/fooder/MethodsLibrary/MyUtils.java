package com.application.fooder.fooder.MethodsLibrary;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.application.fooder.fooder.Fragment.LoginFragment;
import com.application.fooder.fooder.LoginActivity;
import com.application.fooder.fooder.MainActivity;
import com.application.fooder.fooder.R;
import com.google.firebase.auth.FirebaseAuth;

import static android.support.v4.content.ContextCompat.startActivity;

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

    public static void showProgressDialog(Context context, String message){
        ProgressDialog progressDialog = new ProgressDialog(context, R.style.Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage(message);
        progressDialog.show();
    }
}
