package com.example.smail.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.smail.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {

    EditText name, email, dateOfBirth, phoneNum, password_signUp;
    Button btn_signUp;
    TextView txt_login;
    private FirebaseAuth mAuth;
    String TAG ="d";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        dateOfBirth = findViewById(R.id.dateOfBirth);
        phoneNum = findViewById(R.id.phoneNum);
        password_signUp = findViewById(R.id.password_signUp);
        btn_signUp = findViewById(R.id.btn_signUp);
        txt_login = findViewById(R.id.txt_login);
        mAuth = FirebaseAuth.getInstance();
        btn_signUp.setOnClickListener(view -> {
            String nameS = name.getText().toString().trim();
            String emailS = email.getText().toString().trim();
            String dateOfBirthS = dateOfBirth.getText().toString().trim();
            String phoneNumS = phoneNum.getText().toString().trim();
            String passwordS = password_signUp.getText().toString().trim();
            createAccount(emailS,passwordS);
            Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
        txt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, SignActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void createAccount (String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignUpActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}
