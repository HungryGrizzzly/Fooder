package com.application.fooder.fooder.Fragment;

import android.app.Activity;
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
import android.widget.Toast;

import com.application.fooder.fooder.R;
import com.application.fooder.fooder.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

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
                if(isStringEmpty(name.getText().toString())){
                    if(isStringEmpty(email.getText().toString())) {
                        if(isPasswordToSmall(password.getText().toString())) {
                            mAuth = FirebaseAuth.getInstance();
                            mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                                    .addOnCompleteListener((Activity) rootView.getContext(), new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                            if (task.isSuccessful()) {
                                                // Sign in success, update UI with the signed-in user's information
                                                Log.d(TAG, "createUserWithEmail:success");
                                                FirebaseUser user = mAuth.getCurrentUser();
                                                startActivity(new Intent((Activity) rootView.getContext(), MainActivity.class));
                                            } else {
                                                // If sign in fails, display a message to the user.
                                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                            }
                                        }
                                    });
                        } else {
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
                    } else {
                        Toast.makeText(rootView.getContext(), "Enter email", Toast.LENGTH_SHORT).show();
                        Log.e(TAG, "Email span is empty");
                    }
                }
                else {
                    Toast.makeText(rootView.getContext(),"Enter your name",Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "Name span is empty");

                }
            }
        });
        return rootView;
    }
}
