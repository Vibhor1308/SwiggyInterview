package com.example.movieproject.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.movieproject.model.remote.Movie
import com.example.movieproject.model.remote.MovieDetails
import com.example.movieproject.model.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(private val repository : Repository): ViewModel(){
    fun getMovieDetails(): LiveData<MovieDetails> {
        return repository.getMovieData()
    }

    fun fetchMovieData(){
        GlobalScope.launch((Dispatchers.IO)) {
            repository.getMovieDetails()
        }
    }
}