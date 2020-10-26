package com.nanangarifudin.moviecatalogue.ui.movies

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

    @Before
    fun setUp() {
        viewModel = MoviesViewModel()
    }

    @Test
    fun getMovie() {
        val movies = viewModel.getMovie()
        assertNotNull(movies)
        assertEquals(11, movies.size)
    }
}