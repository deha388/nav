package com.demo1.nav.Workout.Split.Beginner;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.demo1.nav.Exercises.Exercise;
import com.demo1.nav.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Locale;

public class B4Fragment extends Fragment {

    TextView  timerValue, btnexercise,intropage;
    Button Next1;
    private static final long START_TIME_IN_MILLIS = 500000;
    private CountDownTimer countDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    FirebaseAuth auth;



    private B1ViewModel mViewModel;

    public static B4Fragment newInstance() {
        return new B4Fragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.b4_fragment,container,false);

        btnexercise = (TextView) view.findViewById(R.id.btnexercise);
        timerValue = (TextView) view.findViewById(R.id.timerValue);
        intropage = (TextView) view.findViewById(R.id.intropage);
       // Next1 = (Button) view.findViewById(R.id.Next1);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(B1ViewModel.class);
        startTimer();
        btnexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth=FirebaseAuth.getInstance();
                database=FirebaseDatabase.getInstance();
                databaseReference=database.getReference("Success");


                databaseReference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue("Beginner1...........Completed ");

                startActivity(new Intent(getActivity(), Splash.class));


            }
        });


        intropage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Exercise.class));
            }
        });

    }

    private void startTimer(){
        countDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDowntText();
            }

            @Override
            public void onFinish() {
            }
        }.start();
        mTimerRunning = true;
    }

    private void updateCountDowntText(){
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeft = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        timerValue.setText(timeLeft);
    }
}
