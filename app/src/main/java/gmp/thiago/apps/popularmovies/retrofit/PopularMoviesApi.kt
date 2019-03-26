package gmp.thiago.apps.popularmovies.retrofit

import gmp.thiago.apps.popularmovies.model.MovieListResult
import gmp.thiago.apps.popularmovies.model.Movies
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PopularMoviesApi {

    // TODO: Here we'll place all the needed @Gets
    @GET("popular?api_key=a16eb88710bc636dc829029f56ff9cf6")
    fun getPopularMovies() : Call<MovieListResult>

    companion object Factory{
        fun create(baseUrl: String) : Retrofit {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build()
        }
    }
}