package com.example.ugly_galleryalpha.Data.Api

import com.example.ugly_galleryalpha.Domain.model.ApiResponce
import com.example.ugly_galleryalpha.Domain.model.DataXXpost
import retrofit2.Call
import retrofit2.http.GET

//Возможно это надо держать в PostRepository ))
interface PostApiService {
    @GET("post")
    fun getPosts(): Call<ApiResponce>
}