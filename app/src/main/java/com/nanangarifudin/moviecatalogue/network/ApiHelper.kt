package com.nanangarifudin.moviecatalogue.network

import com.nanangarifudin.moviecatalogue.data.remote.response.MovieResponse
import retrofit2.Response

interface ApiHelper {

    suspend fun getMovies(): Response<List<MovieResponse>>
}