package com.example.movieproject.model.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movieproject.model.remote.ApiClass
import com.example.movieproject.model.remote.Movie
import com.example.movieproject.model.remote.MovieDetails
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

class Repository @Inject constructor(private val api: ApiClass) {
    companion object {
        private val TAG = "Repository"
    }

    lateinit var movieList: MutableLiveData<List<Movie>>
    var movieDetails = MutableLiveData<MovieDetails>()

    fun getMovieList(): LiveData<List<Movie>> {
        return movieList
    }

    fun getMovieData(): LiveData<MovieDetails> {
        return movieDetails
    }

    suspend fun getMovie() {
        var response = try {
            api.api1.getMovies("C5d1f06b")
        } catch (e: IOException) {
            Log.e(TAG, "getMovie: IO Exception")
            null
        }
        movieList.postValue(response?.body())
    }

    suspend fun getMovieDetails() {
        var response = try {
            api.api2.getMovieDetails("C5d1f06b")
        } catch (e: IOException) {
            Log.e(TAG, "getMovie: IO Exception")
            null
        }
        movieDetails.postValue(response?.body())
    }
}