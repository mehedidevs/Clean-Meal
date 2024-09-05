package com.mehedi.cleanmeal.data.remote

import com.mehedi.cleanmeal.data.model.MealsDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApi {
    
    @GET("api/json/v1/1/search.php")
    suspend fun getSearchMealList(
        @Query("s") query: String
    ): MealsDTO
    
    
    @GET("api/json/v1/1/lookup.php")
    suspend fun getMealDetails(
        @Query("i") i: String
    ): MealsDTO
    
    @GET("api/json/v1/1/filter.php")
    suspend fun getMealDessert(
        @Query("c") i: String
    ): MealsDTO
}