package dev.nekro.newrecipeapp.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.nekro.newrecipeapp.model.Category
import dev.nekro.newrecipeapp.ui.components.CategoryList
import dev.nekro.newrecipeapp.util.Resource

@Composable
fun HomeScreen(
    viewState: Resource<List<Category>>,
    navigateToDetail: (Category) -> Unit
) {

    Box (
        modifier = Modifier.fillMaxSize()
    ) {
        when (viewState) {
            is Resource.Loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

            is Resource.Error -> {
                Text(
                    text = "Error Occured! ${viewState.message}",
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            is Resource.Success -> {
                CategoryList(
                    categories = viewState.data,
                    navigateToDetail = navigateToDetail
                )
            }
        }
    }
}