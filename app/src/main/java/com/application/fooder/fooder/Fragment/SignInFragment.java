package com.application.fooder.fooder.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.application.fooder.fooder.LoginActivity;
import com.application.fooder.fooder.R;
import com.application.fooder.fooder.StartActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Executor;

import butterknife.BindView;
import butterknife.internal.Utils;

import static com.application.fooder.fooder.MethodsLibrary.MyUtils.isPasswordToSmall;
import static com.application.fooder.fooder.MethodsLibrary.MyUtils.isStringEmpty;


public class SignInFragment extends Fragment {

    private FirebaseAuth mAuth;
    private final String TAG = "SIGNINFRAGMENT";

    public SignInFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_sign_in, container, false);
        final EditText email = rootView.findViewById(R.id.input_email);
        final EditText name = rootView.findViewById(R.id.input_name);
        final EditText password = rootView.findViewById(R.id.input_password);
        Button register = rootView.findViewById(R.id.button);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isStringEmpty(email.getText().toString()) && isStringEmpty(name.getText().toString()) && isPasswordToSmall(password.getText().toString())){
                    mAuth = FirebaseAuth.getInstance();
                    mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                            .addOnCompleteListener((Activity) rootView.getContext(), new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d(TAG, "createUserWithEmail:success");
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        startActivity(new Intent((Activity) rootView.getContext(), StartActivity.class ));
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                                                           }
                                }
                            });
                }
                else {
                    Toast.makeText(rootView.getContext(),"Empty strings",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return rootView;
    }
}
