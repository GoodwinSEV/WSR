package com.example.wsr;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    Button btn_sign_up;
    EditText edUsername, edEmail, edPassword, edRePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        btn_sign_up = findViewById((R.id.btn_sign_up));
        edUsername = findViewById((R.id.edUserName));
        edEmail = findViewById((R.id.edEmail));
        edPassword = findViewById((R.id.edPassword));
        edRePassword = findViewById((R.id.edRePassword));



    }
}
