package com.application.fooder.fooder.Fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.application.fooder.fooder.MainActivity;
import com.application.fooder.fooder.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.application.fooder.fooder.MethodsLibrary.MyUtils.isPasswordToSmall;
import static com.application.fooder.fooder.MethodsLibrary.MyUtils.isStringEmpty;
import static com.application.fooder.fooder.MethodsLibrary.MyUtils.*;


public class LoginFragment extends Fragment {

    final String TAG = "LOGINFRAGMENT";
    FirebaseAuth mAuth;
    public LoginFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        final EditText email = rootView.findViewById(R.id.input_email);
        final EditText password = rootView.findViewById(R.id.input_password);
        Button loginBtn = rootView.findViewById(R.id.login_button);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isStringEmpty(email.getText().toString())){
                    if (isPasswordToSmall(password.getText().toString())){
                        showProgressDialog(rootView.getContext(), getString(R.string.authenticating));
                        mAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                                .addOnCompleteListener((Activity) rootView.getContext(), new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            startActivity(new Intent((Activity) rootView.getContext(), MainActivity.class ));
                                            // Sign in success, update UI with the signed-in user's information
                                            Log.d(TAG, "signInWithEmail:success");
                                            FirebaseUser user = mAuth.getCurrentUser();

                                        } else {
                                            // If sign in fails, display a message to the user.
                                            Log.w(TAG, "signInWithEmail:failure", task.getException());

                                        }

                                        // ...
                                    }
                                });
                    }
                    else {
                        Log.e(TAG, "Password span is empty");
                        if(password.getText().length() < 6 && password.getText().length() > 0){
                            Toast.makeText(rootView.getContext(), "Pasword is too short. Needed at least 6 characters", Toast.LENGTH_SHORT).show();
                            Log.e(TAG, "Password is too short");

                        }
                        if(password.getText().length() == 0){
                            Toast.makeText(rootView.getContext(), "Enter password", Toast.LENGTH_SHORT).show();
                            Log.e(TAG, "Password span is empty");
                        }

                    }
                }
                else {
                    Toast.makeText(rootView.getContext(), "Enter email", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "Email span is empty");
                }
            }
        });
        mAuth = FirebaseAuth.getInstance();

        return rootView;
        }


    @Override
    public void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);

    }



}
