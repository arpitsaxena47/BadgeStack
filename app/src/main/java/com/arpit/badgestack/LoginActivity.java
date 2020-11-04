package com.arpit.badgestack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    EditText edtEmail;
    EditText edtPassword;
    Button btnLoginLogin;
    Button btnLoginSignUp;
    RadioButton radioLoginStudent;
    RadioButton radioLoginClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ConstraintLayout layout = findViewById(R.id.loginLayout);
        Drawable background = getResources().getDrawable(R.drawable.bg);
        background.setAlpha(255);
        layout.setBackground(background);

        edtEmail = findViewById(R.id.edtLoginEmail);
        edtPassword = findViewById(R.id.edtLoginPassword);
        mAuth = FirebaseAuth.getInstance();

        btnLoginSignUp = findViewById(R.id.btnLoginSignUp);
        btnLoginLogin = findViewById(R.id.btnLoginLogin);
        radioLoginStudent = findViewById(R.id.radioLoginStudent);
        radioLoginClient = findViewById(R.id.radioLoginClient);

        btnLoginLogin.setOnClickListener(this);
        btnLoginSignUp.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLoginSignUp:
                Intent loginIntent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(loginIntent);
                finish();
                break;
            case R.id.btnLoginLogin:
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                signInAccount(email, password);
                break;
        }
    }
    private void signInAccount(String email, String password) {

        if (email.equals("") || password.equals("")||(!radioLoginClient.isChecked() && !radioLoginStudent.isChecked())) {
            Toast.makeText(LoginActivity.this, "This Field require", Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "signInWithEmail:success");
                            if(radioLoginStudent.isChecked())
                            {
                                Intent showcaseIntent = new Intent(LoginActivity.this , MainActivity.class);
                                startActivity(showcaseIntent);
                                finish();
                            }
                            else
                            if(radioLoginClient.isChecked())
                            {

                                Intent showcaseIntent = new Intent(LoginActivity.this , ClientMainActivity.class);
                                startActivity(showcaseIntent);
                                finish();
                            }
                                    Toast.makeText(LoginActivity.this, "Login Success.",
                                            Toast.LENGTH_SHORT).show();



                        } else {
                            // If sign in fails, display a message to the user.
//                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                            // ...
                        }

                        // ...
                    }
                });
    }


}