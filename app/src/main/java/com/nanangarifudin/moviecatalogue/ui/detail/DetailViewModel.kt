package com.nanangarifudin.moviecatalogue.ui.detail

import androidx.lifecycle.ViewModel
import com.nanangarifudin.moviecatalogue.data.MovieEntity
import com.nanangarifudin.moviecatalogue.data.TvShowEntity
import com.nanangarifudin.moviecatalogue.utils.DataDummy

class DetailViewModel : ViewModel() {

    fun getTvShowById(id: Int, listTvShow: ArrayList<TvShowEntity>): TvShowEntity =
        DataDummy.getTvShowById(id, listTvShow)

    fun getMovieById(id: Int, listMovies : ArrayList<MovieEntity>): MovieEntity =
        DataDummy.getMoviesById(id, listMovies)

    fun getMovie(): List<MovieEntity> = DataDummy.generateDummyMovies()

    fun getTvShow(): List<TvShowEntity> = DataDummy.generateDummyTvShows()

}