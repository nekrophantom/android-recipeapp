package dev.nekro.newrecipeapp.data.remote

import dev.nekro.newrecipeapp.model.CategoryResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("categories.php")
    suspend fun getCategories(): CategoryResponse

}

private val retrofit = Retrofit.Builder()
    .baseUrl("https://www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

var apiService = retrofit.create(ApiService::class.java)