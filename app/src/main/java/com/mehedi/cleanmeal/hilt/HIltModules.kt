package com.mehedi.cleanmeal.hilt

import com.mehedi.cleanmeal.common.Constants
import com.mehedi.cleanmeal.data.remote.MealApi
import com.mehedi.cleanmeal.data.repository.MealDessertRepositoryImpl
import com.mehedi.cleanmeal.data.repository.MealDetailsRepositoryImpl
import com.mehedi.cleanmeal.data.repository.MealSearchRepositoryImpl
import com.mehedi.cleanmeal.domain.repository.MealDesertRepository
import com.mehedi.cleanmeal.domain.repository.MealDetailsRepository
import com.mehedi.cleanmeal.domain.repository.MealSearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object HIltModules {
    
    
    @Provides
    @Singleton
    fun provideMealSearchAPI(): MealApi {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(MealApi::class.java)
    }
    
    
    @Provides
    @Singleton
    fun provideMealSearchRepository(mealSearchAPI: MealApi): MealSearchRepository {
        return MealSearchRepositoryImpl(mealSearchAPI)
    }
    
    
    @Provides
    @Singleton
    fun provideMealDetails(searchMealSearchAPI: MealApi): MealDetailsRepository {
        return MealDetailsRepositoryImpl(searchMealSearchAPI)
    }
    
    @Provides
    @Singleton
    fun provideMealDessert(searchMealAPI: MealApi): MealDesertRepository {
        return MealDessertRepositoryImpl(searchMealAPI)
    }
    
    
}