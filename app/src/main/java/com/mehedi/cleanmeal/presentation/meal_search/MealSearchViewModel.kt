package com.mehedi.cleanmeal.presentation.meal_search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehedi.cleanmeal.common.Resource
import com.mehedi.cleanmeal.domain.use_case.DessertMealsUseCase
import com.mehedi.cleanmeal.domain.use_case.SearchMealsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MealSearchViewModel @Inject constructor(
    private val mealSearchMealsUseCase: SearchMealsUseCase,
    private val desertMealsUseCase: DessertMealsUseCase
) : ViewModel() {
    
    
    private val _mealSearchList = MutableStateFlow<MealSearchState>(MealSearchState())
    val mealSearchList: StateFlow<MealSearchState> = _mealSearchList
    
    init {
        getDessertMeals("Dessert")
    }
    
    fun getSearchMeals(s: String) {
        mealSearchMealsUseCase(s).onEach {
            when (it) {
                is Resource.Loading -> {
                    _mealSearchList.value = MealSearchState(isLoading = true)
                }
                
                is Resource.Success -> {
                    _mealSearchList.value = MealSearchState(data = it.data)
                }
                
                is Resource.Error -> {
                    _mealSearchList.value = MealSearchState(error = it.message ?: "")
                }
            }
        }.launchIn(viewModelScope)
    }
    
    private fun getDessertMeals(s: String) {
        desertMealsUseCase(s).onEach {
            when (it) {
                is Resource.Loading -> {
                    _mealSearchList.value = MealSearchState(isLoading = true)
                }
                
                is Resource.Success -> {
                    _mealSearchList.value = MealSearchState(data = it.data)
                }
                
                is Resource.Error -> {
                    _mealSearchList.value = MealSearchState(error = it.message ?: "")
                }
            }
        }.launchIn(viewModelScope)
    }
    
    
}