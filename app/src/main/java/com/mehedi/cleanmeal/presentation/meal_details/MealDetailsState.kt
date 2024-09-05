package com.mehedi.cleanmeal.presentation.meal_details

import com.mehedi.cleanmeal.domain.model.MealDetails

data class MealDetailsState(
    val isLoading: Boolean = false,
    val data: MealDetails? = null,
    val error: String = ""
) {
}