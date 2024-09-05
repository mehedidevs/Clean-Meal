package com.mehedi.cleanmeal.domain.repository

import com.mehedi.cleanmeal.data.model.MealsDTO

interface MealDetailsRepository {

    suspend fun getMealDetails(id:String): MealsDTO

}