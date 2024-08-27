package com.example.ugly_galleryalpha.Domain.model

data class DataXXpost(
    val categories: List<Category>,
    val description: String,
    val id: Int,
    val photo: String, //Был String
    val title: String,
    val user: User,
    val views_counter: Int
)