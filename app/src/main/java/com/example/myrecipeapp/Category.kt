package com.example.myrecipeapp

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb : String,
    val strCategoryDescription : String) : Parcelable


data class CategoriesResponse(val categories : List<Category>)

