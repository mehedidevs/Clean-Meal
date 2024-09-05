package com.mehedi.cleanmeal.domain.repository

import com.mehedi.cleanmeal.data.model.MealsDTO

interface MealDesertRepository {
    
    suspend fun getMealDessert(s: String): MealsDTO
    
    
}