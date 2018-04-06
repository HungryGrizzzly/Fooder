package com.application.fooder.fooder;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.application.fooder.fooder.Adapters.LoginFragmentAdapter;

import butterknife.ButterKnife;
import butterknife.BindView;

public class LoginActivity extends AppCompatActivity {


@BindView(R.id.viewpager) ViewPager viewPager;
@BindView(R.id.tablayout) TabLayout tabLayout;
public static String buttonName = "Lohn";

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
