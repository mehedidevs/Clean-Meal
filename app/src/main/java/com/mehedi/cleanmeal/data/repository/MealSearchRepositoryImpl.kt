package com.mehedi.cleanmeal.data.repository

import com.mehedi.cleanmeal.data.model.MealsDTO
import com.mehedi.cleanmeal.data.remote.MealApi

import com.mehedi.cleanmeal.domain.repository.MealSearchRepository

class MealSearchRepositoryImpl(private val mealSearchAPI: MealApi) : MealSearchRepository {

    override suspend fun getMealSearch(s: String): MealsDTO {
        return mealSearchAPI.getSearchMealList(s)
    }
}