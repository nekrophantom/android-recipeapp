package dev.nekro.newrecipeapp.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.nekro.newrecipeapp.data.remote.apiService
import dev.nekro.newrecipeapp.data.repository.RecipeRepository
import dev.nekro.newrecipeapp.model.Category
import dev.nekro.newrecipeapp.util.Resource
import kotlinx.coroutines.launch

class RecipeViewModel() : ViewModel() {

    private val _categoryState = mutableStateOf<Resource<List<Category>>>(Resource.Loading)
    private val recipeRepository: RecipeRepository = RecipeRepository(apiService)
    val categoryState: State<Resource<List<Category>>> = _categoryState

    init {
        fetchCategories()
    }

    private fun fetchCategories() {

        viewModelScope.launch {
            try {
                val response = recipeRepository.getCategories()
                _categoryState.value = Resource.Success(response.categories)
            } catch (e: Exception) {
                _categoryState.value = Resource.Error("Error fetching categories! ${e.message}")
            }
        }

    }

}