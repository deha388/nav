package com.demo1.nav.ui.settings;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.demo1.nav.Main.ResetPassword;
import com.demo1.nav.R;
import com.google.firebase.auth.FirebaseAuth;

public class SettingsFragment extends Fragment {

    Button button1;
    Button button2;
    private SettingsViewModel mViewModel;
    private SettingsViewModel settingsViewModel;
    FirebaseAuth auth;

    @SuppressLint("WrongViewCast")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_settings, container, false);


        button1 = (Button) view.findViewById(R.id.Language);
        button2 = (Button) view.findViewById(R.id.Change);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        mViewModel = ViewModelProviders.of(this).get(SettingsViewModel.class);


        // give an event to another page
        auth=FirebaseAuth.getInstance();
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(getActivity(), ResetPassword.class));




            }
        });
    }
}