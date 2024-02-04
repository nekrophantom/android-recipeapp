package dev.nekro.newrecipeapp.navigation

sealed class Navigation (val route: String) {

    object HomeScreen:Navigation("home")
    object DetailScreen:Navigation("detail")

}