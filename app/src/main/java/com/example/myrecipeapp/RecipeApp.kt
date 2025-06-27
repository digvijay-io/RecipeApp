package com.example.myrecipeapp

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp(navController: NavHostController, modifier: Modifier = Modifier){
    val recipeViewModel: MainViewModel = viewModel()
    val viewstate by recipeViewModel.categoriesState

    NavHost(navController = navController, startDestination = Screen.RecipeScreen.route){
        composable(Screen.RecipeScreen.route){
            RecipeScreen(viewState = viewstate, navigateToDetail = {
                navController.currentBackStackEntry?.savedStateHandle?.set("category", it)
                navController.navigate(Screen.DetailScreen.route)
            })
        }

        composable (Screen.DetailScreen.route){
            val category = navController.previousBackStackEntry?.savedStateHandle?.get<Category>("category") ?:
            Category("", "", "", "")
            CategoryDetailScreen(category = category)
        }
    }
}