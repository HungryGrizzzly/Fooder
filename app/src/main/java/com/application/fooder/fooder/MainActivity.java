package com.application.fooder.fooder;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.Toast;

import com.application.fooder.fooder.Adapters.NewsFeedFragmentAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.application.fooder.fooder.MethodsLibrary.MyUtils.*;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.application.fooder.fooder.MethodsLibrary.MyUtils.showProgressDialog;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.exitbutton)
    Button exitBtn;
    @BindView(R.id.viewpagermainactivity)
    ViewPager viewPager;
    @BindView(R.id.main_activity_tablayout)
    TabLayout tabLayout;
    @BindView(R.id.maintoolbar)
    Toolbar toolbar;
    @BindView(R.id.menubutton)
    ImageView menuButton;
    private FirebaseAuth mAuth;
    private String TAG = "MAIN ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mAuth = FirebaseAuth.getInstance();


        NewsFeedFragmentAdapter newsFeedFragmentAdapter = new NewsFeedFragmentAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(newsFeedFragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
        setSupportActionBar(toolbar);

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View view = v;
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, v);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(MainActivity.this,"You Clicked : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        switch (item.getItemId()){
                            case 0:
                            case 1:
                            case R.id.signout: showProgressDialog(MainActivity.this, getString(R.string.signout));
                                signOut();



                        }
                        return true;
                    }
                });

                popupMenu.show();//showing popup menu
            }
        });

    }
    @Override
    public void onStart(){
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser == null){
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            Log.e(TAG, "Moving to the login activity");
        }
        else {
            Log.e(TAG, "User is authenticated");
        }
    }

    private void signOut(){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }
}
