package com.example.asm_ph56058__and103;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    //192.168.1.104
     //10.24.35.16
    // 192.168.224.115


    //192.168.224.128
    private static final String BASE_URL = "http://192.168.1.104:3030/api/"; // Thay đổi URL phù hợp với API của bạn
    private static Retrofit retrofit;


    public static Retrofit getInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
