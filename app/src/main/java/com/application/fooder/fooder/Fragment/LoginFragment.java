package com.application.fooder.fooder.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.application.fooder.fooder.LoginActivity;

import com.application.fooder.fooder.Adapters.LoginFragmentAdapter;
import com.application.fooder.fooder.R;
import com.application.fooder.fooder.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LoginFragment extends Fragment {

    public LoginFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        return rootView;
        }


    @Override
    public void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);


    }



}
