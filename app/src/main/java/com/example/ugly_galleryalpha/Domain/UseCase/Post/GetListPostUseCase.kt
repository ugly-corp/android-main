package com.example.ugly_galleryalpha.Domain.UseCase.Post

import com.example.ugly_galleryalpha.Domain.model.DataXXpost

class GetListPostUseCase(private val postRepository: PostRepository) {
    fun execute(callback: (List<DataXXpost>?) -> Unit) {
        postRepository.getListPost(callback)
    }
}