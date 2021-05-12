package com.nanangarifudin.moviecatalogue.ui.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.nanangarifudin.moviecatalogue.R
import com.udindev.moviehilt.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_movies.*

@AndroidEntryPoint
class MoviesFragment : Fragment() {

    private val movieViewModel: MoviesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
//            val viewModel = ViewModelProvider(
//                this,
//                ViewModelProvider.NewInstanceFactory()
//            )[MoviesViewModel::class.java]

            movieViewModel.users.observe(viewLifecycleOwner, {
                when (it.status) {
                    Status.SUCCESS -> {
                        it.data?.let { users ->
                            for (movie in users) {
                                movie.results?.let { it1 ->
                                    val moviesAdapter = MoviesAdapter()
                                    moviesAdapter.setData(it1)
                                    with(rv_movies) {
                                        layoutManager = LinearLayoutManager(context)
                                        setHasFixedSize(true)
                                        adapter = moviesAdapter
                                    }
                                }
                            }
                        }
                    }

                    Status.LOADING -> {

                    }
                    Status.ERROR -> {
                        //Handle Error
                        Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                    }
                }
            })

        }
    }


}