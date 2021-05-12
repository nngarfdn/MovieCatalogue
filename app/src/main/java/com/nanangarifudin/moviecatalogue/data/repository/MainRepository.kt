package com.nanangarifudin.moviecatalogue.data.repository

import com.nanangarifudin.moviecatalogue.network.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {
    suspend fun getMovies() =  apiHelper.getMovies()
}