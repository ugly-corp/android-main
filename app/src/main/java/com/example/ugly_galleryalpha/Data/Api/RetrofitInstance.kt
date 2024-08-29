package com.example.ugly_galleryalpha.Data.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "http://api.dev.ugly.gallery/api/v1/"

    // API-сервис для постов
    val postApi: PostApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PostApiService::class.java)
    }

    // API-сервис для категорий
    val categoryApi: CategoryApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CategoryApiService::class.java)
    }
}