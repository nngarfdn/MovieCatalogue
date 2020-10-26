package com.nanangarifudin.moviecatalogue.ui.tvshow

import androidx.lifecycle.ViewModel
import com.nanangarifudin.moviecatalogue.data.TvShowEntity
import com.nanangarifudin.moviecatalogue.utils.DataDummy

class TVShowViewModel : ViewModel() {

    fun getTVShow() : List<TvShowEntity> = DataDummy.generateDummyTvShows()

}