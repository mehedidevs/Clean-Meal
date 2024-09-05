package com.mehedi.cleanmeal.presentation.meal_search

import com.mehedi.cleanmeal.domain.model.Meal

data class MealSearchState(
    val isLoading: Boolean = false,
    val data: List<Meal>? = null,
    val error: String = ""
)