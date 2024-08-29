// NetWorkCategoryImpl.kt
package com.example.ugly_galleryalpha.Data

import android.util.Log
import com.example.ugly_galleryalpha.Data.Api.CategoryApiService
import com.example.ugly_galleryalpha.Domain.UseCase.Category.CategoryRepository
import com.example.ugly_galleryalpha.Domain.model.CategoryResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NetWorkCategoryImpl(private val categoryApi: CategoryApiService) : CategoryRepository {

    override fun getCategories(callback: (CategoryResponse?) -> Unit) {
        categoryApi.getCategories().enqueue(object : Callback<CategoryResponse> {
            override fun onResponse(call: Call<CategoryResponse>, response: Response<CategoryResponse>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    Log.d("NetWorkApi", "Request successful. Data received: $data")
                    callback(data)
                } else {
                    Log.e("NetWorkApi", "Request failed. Response code: ${response.code()}. Error body: ${response.errorBody()?.string()}")
                    callback(null)
                }
            }

            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
                Log.e("NetWorkApi", "Request failed. Error: ${t.message}")
                callback(null)
            }
        })
    }
}



