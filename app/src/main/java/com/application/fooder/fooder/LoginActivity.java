package com.application.fooder.fooder;

import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.application.fooder.fooder.Adapters.LoginFragmentAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.ButterKnife;
import butterknife.BindView;

public class LoginActivity extends AppCompatActivity {

private final String TAG = "REGISTRATION";
@BindView(R.id.viewpager) ViewPager viewPager;
@BindView(R.id.tablayout) TabLayout tabLayout;
public static String buttonName = "Lohn";
private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);


        final LoginFragmentAdapter[] loginAdapter = {new LoginFragmentAdapter(LoginActivity.this, getSupportFragmentManager())};
        viewPager.setAdapter(loginAdapter[0]);
        tabLayout.setupWithViewPager(viewPager);
    }
}
