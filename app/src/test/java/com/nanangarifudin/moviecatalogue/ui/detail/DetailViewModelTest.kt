package com.nanangarifudin.moviecatalogue.ui.detail

import com.nanangarifudin.moviecatalogue.R
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import java.util.ArrayList

class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel

    @Before
    fun setUp() {
        viewModel = DetailViewModel()
    }

    @Test
    fun getTvShowById() {
        val allTvShow = viewModel.getTvShow()
        val tvShow = viewModel.getTvShowById(1, allTvShow as ArrayList)
        assertNotNull(allTvShow)
        assertEquals(11, allTvShow.size)
        assertNotNull(tvShow)
        assertEquals("Doom Patrol", tvShow.title)
        assertEquals( R.drawable.poster_doom_patrol, tvShow.poster)
        assertEquals("The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.", tvShow.description)

    }

    @Test
    fun getMovieById() {
        val allMovie = viewModel.getMovie()
        val movie = viewModel.getMovieById(1, allMovie as ArrayList)
        assertNotNull(allMovie)
        assertEquals(11, allMovie.size)
        assertNotNull(movie)
        assertEquals("Alita: Battle Angel", movie.title)
        assertEquals( R.drawable.poster_alita, movie.poster)
        assertEquals("When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.", movie.description)
    }

    @Test
    fun getMovie() {
        val movies = viewModel.getMovie()
        assertNotNull(movies)
        assertEquals(11, movies.size)
    }

    @Test
    fun getTvShow() {
        val tvshow = viewModel.getTvShow()
        assertNotNull(tvshow)
        assertEquals(11, tvshow.size)
    }
}