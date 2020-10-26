package com.nanangarifudin.moviecatalogue.ui.movies

import androidx.lifecycle.ViewModel
import com.nanangarifudin.moviecatalogue.data.MovieEntity
import com.nanangarifudin.moviecatalogue.utils.DataDummy

class MoviesViewModel : ViewModel(){

    fun getMovie() : List<MovieEntity> = DataDummy.generateDummyMovies()

}