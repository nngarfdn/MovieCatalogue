package com.nanangarifudin.moviecatalogue.network

import com.nanangarifudin.moviecatalogue.data.remote.response.MovieResponse
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun getMovies(): Response<List<MovieResponse>> = apiService.getMovies()

}