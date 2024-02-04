package dev.nekro.newrecipeapp.data.repository

import dev.nekro.newrecipeapp.data.remote.ApiService
import dev.nekro.newrecipeapp.model.Category

class RecipeRepository(
    private val apiService: ApiService
) {
    suspend fun getCategories() = apiService.getCategories()
}