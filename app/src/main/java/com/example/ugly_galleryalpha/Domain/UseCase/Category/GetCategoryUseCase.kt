package com.example.ugly_galleryalpha.Domain.UseCase.Category

import com.example.ugly_galleryalpha.Domain.model.DataX



class GetCategoryUseCase(private val categoryRepository: CategoryRepository) {
    fun execute(callback: (List<DataX>?) -> Unit) {
        categoryRepository.getCategories { response ->
            callback(response?.data)
        }
    }
}
