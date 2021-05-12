package com.nanangarifudin.moviecatalogue.ui.movies

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.nanangarifudin.moviecatalogue.data.remote.response.MovieResponse
import com.nanangarifudin.moviecatalogue.data.repository.MainRepository
import com.udindev.moviehilt.utils.NetworkHelper
import com.udindev.moviehilt.utils.Resource
import kotlinx.coroutines.launch

class MoviesViewModel @ViewModelInject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val _users = MutableLiveData<Resource<List<MovieResponse>>>()
    val users: LiveData<Resource<List<MovieResponse>>>
        get() = _users

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            _users.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getMovies().let {
                    if (it.isSuccessful) {
                        _users.postValue(Resource.success(it.body()))
                    } else _users.postValue(Resource.error(it.errorBody().toString(), null))
                }
            } else _users.postValue(Resource.error("No internet connection", null))
        }
    }
}