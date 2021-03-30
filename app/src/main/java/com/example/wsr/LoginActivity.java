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

public class LoginActivity extends AppCompatActivity {
    Button sign_in, go_sign_up;
    EditText username, password;
    TextView forgot_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        username = findViewById(R.id.username);
        password = findViewById(R.id.editPassword);
        forgot_pass = findViewById(R.id.forgot_pass);
        sign_in = findViewById(R.id.btn_sign_in);
        go_sign_up = findViewById(R.id.btn_go_sign_up);

 //Функция нажатия на кнопку, Войти с логином
        sign_in.setOnClickListener(new View.OnClickListener() {
          @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(username.getText().toString())|| TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(LoginActivity.this, "Username / Password Required",Toast.LENGTH_LONG).show();
                }else{
                    login();
                }
            }
        });

//Метод, перехода на экран с Регистрацией
        go_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void login(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(username.getText().toString());
        loginRequest.setPassword(password.getText().toString());

        Call<LoginResponce> loginResponseCall = ApiClient.getUserService().Userlogin(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponce>() {
            @Override
            public void onResponse(Call<LoginResponce> call, Response<LoginResponce> response) {
                if (response.isSuccessful() ){
                    Toast.makeText(LoginActivity.this,"Login Successful", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(LoginActivity.this,"WHY???", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponce> call, Throwable t) {
                Toast.makeText(LoginActivity.this,"Throwable " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
