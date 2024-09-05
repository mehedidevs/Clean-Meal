package com.mehedi.cleanmeal.data.repository

import com.mehedi.cleanmeal.data.model.MealsDTO
import com.mehedi.cleanmeal.data.remote.MealApi
import com.mehedi.cleanmeal.domain.repository.MealDetailsRepository

class MealDetailsRepositoryImpl(private val mealSearchAPI: MealApi) : MealDetailsRepository {
    
    override suspend fun getMealDetails(id: String): MealsDTO {
        return mealSearchAPI.getMealDetails(id)
    }
}