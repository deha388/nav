package com.demo1.nav.Main;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.demo1.nav.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    EditText edit_email1,edit_password1;
    Button Login1;
    TextView kayıtsayfasına_git;
    FirebaseAuth girisyetkisi;
    TextView password_vergessen;
    private FirebaseAuth auth;
    private String email, password;
    private static final String TAG = "Login";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edit_email1 = findViewById(R.id.edit_email1);
        edit_password1 = findViewById(R.id.edit_password1);
        Login1 = findViewById(R.id.Login1);
        kayıtsayfasına_git = findViewById(R.id.kayıtsayfasına_git);
        girisyetkisi = FirebaseAuth.getInstance();



        kayıtsayfasına_git.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, SignUp.class));
            }
        });



        auth = FirebaseAuth.getInstance();

        //checking if user is logged in
        if (auth.getCurrentUser() != null) {
            updateUI(auth.getCurrentUser());
        }

        Login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog pdgiris= new ProgressDialog(Login.this);
                pdgiris.setMessage("Logging....");
                pdgiris.show();
                email = edit_email1.getText().toString();

                password = edit_password1.getText().toString();
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "signInWithEmail:success");
                                    FirebaseUser user = auth.getCurrentUser();
                                    updateUI(user);
                                    pdgiris.dismiss();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "signInWithEmail:failure", task.getException());
                                    Toast.makeText(getApplicationContext(), "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }

                                // ...
                            }
                        });
            }
        });


    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = auth.getCurrentUser();
        if (currentUser != null) {
            updateUI(currentUser);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = auth.getCurrentUser();
        if (currentUser != null) {
            updateUI(currentUser);
        }
    }

    public void updateUI(FirebaseUser currentUser) {
        Intent profileIntent = new Intent(getApplicationContext(), Home.class);
        profileIntent.putExtra("email", currentUser.getEmail());
        Log.v("DATA", currentUser.getUid());
        startActivity(profileIntent);
    }


//        Login1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final ProgressDialog pdgiris= new ProgressDialog(Login.this);
//                pdgiris.setMessage("Logging....");
//                pdgiris.show();
//                String str_password1=edit_password1.getText().toString();
//                String str_email1=edit_email1.getText().toString();
//
//                if(TextUtils.isEmpty(str_email1)|| TextUtils.isEmpty(str_password1)){
//                    Toast.makeText(Login.this, "Please fill in the blanks",Toast.LENGTH_SHORT).show();
//
//                }
//                else{
//                    girisyetkisi.signInWithEmailAndPassword(str_email1,str_password1)
//                            .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
//                                @Override
//                                public void onComplete(@NonNull Task<AuthResult> task) {
//                                    if(task.isSuccessful()){
//                                        DatabaseReference d= FirebaseDatabase.getInstance().getReference().child("Users").child(girisyetkisi.getCurrentUser().getUid());
//                                        d.addValueEventListener(new ValueEventListener() {
//                                            @Override
//                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                                                pdgiris.dismiss();
//                                                Intent intent=new Intent(Login.this, Home.class);
//                                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
//                                                startActivity(intent);
//                                                finish();
//
//
//                                            }
//
//                                            @Override
//                                            public void onCancelled(@NonNull DatabaseError databaseError) {
//                                                pdgiris.dismiss();
//
//                                            }
//                                        });
//
//
//                                    }
//                                    else{
//                                        pdgiris.dismiss();
//                                        Toast.makeText(Login.this,"Cannot Login" , Toast.LENGTH_LONG).show();
//
//                                    }
//                                }
//                            });
//                }
//
//
//            }
//        });
    }

