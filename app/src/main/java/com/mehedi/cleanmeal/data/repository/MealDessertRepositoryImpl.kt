package com.mehedi.cleanmeal.data.repository

import com.mehedi.cleanmeal.data.model.MealsDTO
import com.mehedi.cleanmeal.data.remote.MealApi
import com.mehedi.cleanmeal.domain.repository.MealDesertRepository

class MealDessertRepositoryImpl(private val mealSearchAPI: MealApi) : MealDesertRepository {
    
    
    override suspend fun getMealDessert(s: String): MealsDTO {
        return mealSearchAPI.getMealDessert(s)
    }
}