package com.stdevsec.lenguajewidget;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class RetrofitClient {
    private static Retrofit retrofit;
    private static final String BASE_URL = "http://localhost:8080/api/cards"; // Cambia la URL

    public static Retrofit getInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public interface FlashcardService {
        @GET("/random")
        Call<CardDTO> getRandomCard();
    }
}
