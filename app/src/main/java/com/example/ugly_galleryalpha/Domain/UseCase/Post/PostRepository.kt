package com.example.ugly_galleryalpha.Domain.UseCase.Post

import com.example.ugly_galleryalpha.Domain.model.DataXXpost

interface PostRepository {

    fun getListPost(callback: (List<DataXXpost>?) -> Unit)
}