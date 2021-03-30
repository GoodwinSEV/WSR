package com.example.wsr;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    Button btn_sign_up;
    EditText edFirstName, edSecondName, edEmail, edPassword, edRePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        btn_sign_up = findViewById((R.id.btn_sign_up));
        edFirstName = findViewById((R.id.edFirstName));
        edSecondName = findViewById((R.id.edSecondName));
        edEmail = findViewById((R.id.edEmail));
        edPassword = findViewById((R.id.edPassword));
        edRePassword = findViewById((R.id.edRePassword));

        //Функция нажатия на кнопку, Войти с логином
        btn_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    register();
                }

        });

    }

    public void register(){
        RegisterRequest registerRequest = new RegisterRequest();
        RegisterRequest.   (edFirstName.getText().toString());
        RegisterRequest.setSecondName(edFirstName.getText().toString());
        RegisterRequest.setPassword(edPassword.getText().toString());

        Call<RegisterResponse> loginResponseCall = ApiClient.getUserService().registerUsers(registerRequest);
        RegisterResponseCall.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.isSuccessful() ){
                    Toast.makeText(RegisterRequest.this,"Login Successful", Toast.LENGTH_LONG).show();
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
