package com.demo1.nav.Workout.Split.Beginner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.demo1.nav.R;

public class Beg extends AppCompatActivity {
    B1Fragment fragment=new B1Fragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beg);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.ada, fragment);
        fragmentTransaction.commit();
    }

}
