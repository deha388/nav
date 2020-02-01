package com.demo1.nav.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.demo1.nav.Exercises.Exercise;
import com.demo1.nav.Profil.Profil;
import com.demo1.nav.R;
import com.demo1.nav.Workout.StartWorkout;

public class HomeFragment extends Fragment  {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        ImageView imageView1=root.findViewById(R.id.imageView1);
        ImageView imageView2=root.findViewById(R.id.imageView2);
        ImageView imageView3=root.findViewById(R.id.imageView3);

        imageView2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                startActivity(new Intent(getActivity(), StartWorkout.class));


            }
        });
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Exercise.class));


            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getActivity(), Profil.class));


            }
        });


        return root;
    }

}