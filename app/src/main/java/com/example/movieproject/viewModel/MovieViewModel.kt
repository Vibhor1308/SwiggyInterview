package com.example.movieproject.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.movieproject.model.remote.Movie
import com.example.movieproject.model.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(val repository:Repository) : ViewModel(){

    fun getMovieList():LiveData<List<Movie>>{
        return repository.getMovieList()
    }

    fun fetchMovies(){
        GlobalScope.launch((Dispatchers.IO)) {
            repository.getMovie()
        }
    }
}