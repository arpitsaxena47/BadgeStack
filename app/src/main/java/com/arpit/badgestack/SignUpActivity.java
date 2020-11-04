package com.arpit.badgestack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.arpit.badgestack.ui.showcase.ShowcaseActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;


public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    EditText edtEmail;
    EditText edtPassword;
    EditText edtUsername;
    Button btnSignUpLogin;
    Button btnSignUpSignUp;
    RadioButton radioStudent;
    RadioButton radioClient;
    CustomAuthenticationToken customAuthenticationToken;
    String username;
    String identity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ConstraintLayout layout = findViewById(R.id.signUpLayout);
        Drawable background = getResources().getDrawable(R.drawable.bg);
        background.setAlpha(255);
        layout.setBackground(background);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtUsername = findViewById(R.id.edtUsername);
        radioStudent = findViewById(R.id.radioStudent);
        radioClient = findViewById(R.id.radioClient);


        mAuth = FirebaseAuth.getInstance();
        btnSignUpLogin = findViewById(R.id.btnSignUpLogin);
        btnSignUpSignUp = findViewById(R.id.btnSignUpSignUp);

        btnSignUpSignUp.setOnClickListener(this);
        btnSignUpLogin.setOnClickListener(this);
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
//        updateUI(currentUser);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnSignUpLogin:
                Intent loginIntent = new Intent(SignUpActivity.this , LoginActivity.class);
                startActivity(loginIntent);
                finish();
                break;
            case R.id.btnSignUpSignUp:
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                createAccount(email , password);
                break;
        }

    }
    private void createAccount( final String email, final String password) {

        if(email.equals("") || password.equals("")|| username.equals("")||(!radioClient.isChecked() && !radioStudent.isChecked()) ){
            Toast.makeText(SignUpActivity.this,"All fields are required" , Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            if(radioStudent.isChecked())
                            {
                                Intent showcaseIntent = new Intent(SignUpActivity.this , MainActivity.class);
                                startActivity(showcaseIntent);
                                finish();
                            }
                            else
                                if(radioClient.isChecked())
                                {

                                    Intent showcaseIntent = new Intent(SignUpActivity.this , ClientMainActivity.class);
                                    startActivity(showcaseIntent);
                                    finish();
                                }
                                     Toast.makeText(SignUpActivity.this, "Signed Up Successfully " ,
                                             Toast.LENGTH_SHORT).show();
                                     FirebaseUser user = mAuth.getCurrentUser();


                             }
                            // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "createUserWithEmail:success");

//                            updateUI(user);
                         else {
                            // If sign in fails, display a message to the user.
//                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignUpActivity.this, "Authentication failed." + task.getException(),
                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }

                        // ...
                    }
                });
}

}