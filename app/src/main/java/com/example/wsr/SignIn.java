package com.example.wsr;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignIn extends AppCompatActivity {
    EditText username, password;
    TextView forgot_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        username = findViewById(R.id.username);
        password = findViewById(R.id.editPassword);
        forgot_pass = findViewById(R.id.forgot_pass);
        Button sign_in = findViewById(R.id.btn_sign_in);
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(username.getText().toString())|| TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(SignIn.this, "Username / Password Required",Toast.LENGTH_LONG).show();
                }else{
                    login();
                }
            }
        });

        Button go_sign_up = findViewById(R.id.btn_go_sign_up);
        go_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignIn.this, SignUp.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void login(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(username.getText().toString());
        loginRequest.setPassword(password.getText().toString());
        Call<LoginResponce> loginResponseCall = ApiClient.getUserService().userLogin(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponce>() {
            @Override
            public void onResponse(Call<LoginResponce> call, Response<LoginResponce> response) {
                if (response.isSuccessful() ){
                    Toast.makeText(SignIn.this,"Login Successful", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(SignIn.this,"Login Failed", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponce> call, Throwable t) {
                Toast.makeText(SignIn.this,"Throwable " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
