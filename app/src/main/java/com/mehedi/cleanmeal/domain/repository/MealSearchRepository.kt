package com.mehedi.cleanmeal.domain.repository

import com.mehedi.cleanmeal.data.model.MealsDTO

interface MealSearchRepository {

    suspend fun getMealSearch(s:String): MealsDTO



}