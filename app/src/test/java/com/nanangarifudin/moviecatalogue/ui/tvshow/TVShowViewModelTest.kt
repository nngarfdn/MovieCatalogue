package com.nanangarifudin.moviecatalogue.ui.tvshow

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class TVShowViewModelTest {

    private lateinit var viewModel: TVShowViewModel

    @Before
    fun setUp() {
        viewModel = TVShowViewModel()
    }

    @Test
    fun getTVShow() {
        val tvshow = viewModel.getTVShow()
        assertNotNull(tvshow)
        assertEquals(11, tvshow.size)
    }
}