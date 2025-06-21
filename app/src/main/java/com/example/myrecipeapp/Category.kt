package com.example.myrecipeapp

data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategorythumb : String,
    val strCategoryDescription : String
)

data class CategoriesResponse(val Categories : List<Category>)

