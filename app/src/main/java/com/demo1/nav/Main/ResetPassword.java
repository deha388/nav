package com.demo1.nav.Main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.demo1.nav.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPassword extends AppCompatActivity {
    EditText edt1;
    Button bt1;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        edt1 = findViewById(R.id.user_email);
        bt1 = findViewById(R.id.bt1);

        auth=FirebaseAuth.getInstance();

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.sendPasswordResetEmail(edt1.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                   if(task.isSuccessful()){
                       Toast.makeText(ResetPassword.this,"Password send to your email",Toast.LENGTH_LONG).show();

                       new Handler().postDelayed(new Runnable() {
                           @Override
                           public void run() {
                               startActivity(new Intent(ResetPassword.this, Home.class));
                           }
                       }, 3500);


                   }else {
                       Toast.makeText(ResetPassword.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();

                   }
                    }
                });

            }
        });
    }


}
