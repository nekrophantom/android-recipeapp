package dev.nekro.newrecipeapp.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.nekro.newrecipeapp.model.Category

@Composable
fun CategoryList(
    categories: List<Category>,
    navigateToDetail: (Category) -> Unit
) {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Fixed(2)
    ){
        items (categories) {
            category -> CategoryItem(
                category = category,
                navigateToDetail = navigateToDetail
            )
        }
    }
}