package com.example.ugly_galleryalpha.Domain.UseCase.Category

import com.example.ugly_galleryalpha.Domain.model.CategoryResponse
import com.example.ugly_galleryalpha.Domain.model.DataX
import com.example.ugly_galleryalpha.Domain.model.categoryModel


interface CategoryRepository {
    fun getCategories(callback: (CategoryResponse?) -> Unit)
}
