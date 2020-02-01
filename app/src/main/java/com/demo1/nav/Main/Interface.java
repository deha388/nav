package com.demo1.nav.Main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.demo1.nav.R;
import com.demo1.nav.ui.settings.SettingsFragment;

public class Interface extends AppCompatActivity {

    SettingsFragment fragment=new SettingsFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.settings, fragment);
        fragmentTransaction.commit();
    }
}
