package com.iman.newsapp.di

import android.content.Context
import com.iman.newsapp.data.NewsRepository
import com.iman.newsapp.data.local.room.NewsDatabase
import com.iman.newsapp.data.remote.retrofit.ApiConfig

object Injection {
    fun provideRepository(context: Context): NewsRepository {
        val apiService = ApiConfig.getApiService()
        val database = NewsDatabase.getInstance(context)
        val dao = database.newsDao()
        return NewsRepository.getInstance(apiService, dao)
    }
}