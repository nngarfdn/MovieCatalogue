package com.nanangarifudin.moviecatalogue.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import com.nanangarifudin.moviecatalogue.R
import com.nanangarifudin.moviecatalogue.data.MovieEntity
import com.nanangarifudin.moviecatalogue.data.TvShowEntity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIES = "extra_movies"
        const val EXTRA_TVSHOW = "extra_tvshow"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailViewModel::class.java]

        val extrasMovie = intent.extras?.getParcelable<MovieEntity>(EXTRA_MOVIES)
        val extrasTvShow = intent.extras?.getParcelable<TvShowEntity>(EXTRA_TVSHOW)

        if (extrasMovie != null) {
            setViewMovie(viewModel, extrasMovie)
        } else if (extrasTvShow != null){
            setViewTvShow(viewModel, extrasTvShow)
        }

        imgShare.setOnClickListener { share() }
    }

    private fun share() {
        val title = txtTitleDetail.text.toString()
        val description = txtDescriptionDetail.text.toString()
        val share = "$title\n$description"
        ShareCompat.IntentBuilder
            .from(this).setChooserTitle("Share :")
            .setText(share).setType("text/plain")
            .startChooser()
    }

    private fun setViewTvShow(
        viewModel: DetailViewModel,
        extrasTvShow: TvShowEntity
    ) {
        val allTvShow = viewModel.getTvShow()
        val tvShow =
            viewModel.getTvShowById(extrasTvShow.id, allTvShow as ArrayList<TvShowEntity>)
        Picasso.get()
            .load(tvShow.poster)
            .fit()
            .centerCrop()
            .into(imgDetail)
        txtTitleDetail.text = tvShow.title
        txtDescriptionDetail.text = tvShow.description
    }

    private fun setViewMovie(
        viewModel: DetailViewModel,
        extrasMovie: MovieEntity
    ) {
        val allMovie = viewModel.getMovie()
        val movies = viewModel.getMovieById(extrasMovie.id, allMovie as ArrayList<MovieEntity>)
        Picasso.get()
            .load(movies.poster)
            .fit()
            .centerCrop()
            .into(imgDetail)
        txtTitleDetail.text = movies.title
        txtDescriptionDetail.text = movies.description
    }

}