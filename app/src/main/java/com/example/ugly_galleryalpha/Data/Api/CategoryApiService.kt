
package com.example.ugly_galleryalpha.Data.Api

import com.example.ugly_galleryalpha.Domain.model.CategoryResponse
import com.example.ugly_galleryalpha.Domain.model.DataX
import retrofit2.Call
import retrofit2.http.GET

interface CategoryApiService {
    @GET("category")
    fun getCategories(): Call<CategoryResponse>
}
