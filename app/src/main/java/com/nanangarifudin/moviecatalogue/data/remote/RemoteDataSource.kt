package com.nanangarifudin.moviecatalogue.data.remote

import com.nanangarifudin.moviecatalogue.utils.DataDummy

class RemoteDataSource private constructor(private val dataDummy : DataDummy) {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(dataDummy: DataDummy): RemoteDataSource =
                instance ?: synchronized(this) {
                    RemoteDataSource(dataDummy).apply { instance = this }
                }
    }

//    fun getAllMovies(): List<MoviesData> = dataDummyHelper.generateDummyMovies()
//
//    fun getAllTvShows(): List<TvShowData> = dataDummyHelper.generateDummyTvShows()
}