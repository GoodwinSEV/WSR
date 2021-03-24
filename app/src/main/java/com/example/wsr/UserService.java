package com.example.wsr;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("signup/")
    Call<RegisterResponse> registerUsers(@Body RegisterRequest registerRequest);

    @POST("login/")
    Call<LoginResponce> Userlogin(@Body LoginRequest loginRequest);
}
