package dev.nekro.newrecipeapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.nekro.newrecipeapp.model.Category
import dev.nekro.newrecipeapp.ui.screen.CategoryDetailScreen
import dev.nekro.newrecipeapp.ui.screen.HomeScreen
import dev.nekro.newrecipeapp.viewmodel.RecipeViewModel

@Composable
fun RecipeApp(navController: NavHostController) {

    val recipeViewModel: RecipeViewModel = viewModel()
    val viewState by recipeViewModel.categoryState


    NavHost(
        navController = navController,
        startDestination = Navigation.HomeScreen.route
    ) {
        composable(route = Navigation.HomeScreen.route){
            HomeScreen(
                viewState = viewState,
                navigateToDetail = {
                    navController.currentBackStackEntry?.savedStateHandle?.set("cat", it)
                    navController.navigate(Navigation.DetailScreen.route)
                }
            )
        }

        composable(route = Navigation.DetailScreen.route) {
            val category = navController.previousBackStackEntry?.savedStateHandle?.get<Category>("cat") ?: Category("", "", "", "")
            CategoryDetailScreen(category = category)
        }
    }
}