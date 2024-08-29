package com.example.ugly_galleryalpha.Data

import android.util.Log
import com.example.ugly_galleryalpha.Data.Api.RetrofitInstance
import com.example.ugly_galleryalpha.Domain.UseCase.Post.PostRepository
import com.example.ugly_galleryalpha.Domain.model.ApiResponce
import com.example.ugly_galleryalpha.Domain.model.DataXXpost
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetWorkPostImpl : PostRepository {

    override fun getListPost(callback: (List<DataXXpost>?) -> Unit) {
        RetrofitInstance.postApi.getPosts().enqueue(object : Callback<ApiResponce> {
            override fun onResponse(call: Call<ApiResponce>, response: Response<ApiResponce>) {
                if (response.isSuccessful) {
                    val data = response.body()?.data
                    Log.d("NetWorkApi", "Request successful. Data received: $data")
                    callback(data)
                } else {
                    Log.e("NetWorkApi", "Request failed. Response code: ${response.code()}. Error body: ${response.errorBody()?.string()}")
                    callback(emptyList())
                }
            }

            override fun onFailure(call: Call<ApiResponce>, t: Throwable) {
                Log.e("NetWorkApi", "Request failed. Error: ${t.message}")
                callback(emptyList())
            }
        })
    }
}