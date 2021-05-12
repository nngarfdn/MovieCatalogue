package com.nanangarifudin.moviecatalogue.network

import com.nanangarifudin.moviecatalogue.data.remote.response.MovieResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("3/discover/movie?sort_by=popularity.desc&api_key=732012d703178472fe5df9861a323d1d")
    suspend fun getMovies(): Response<List<MovieResponse>>

}