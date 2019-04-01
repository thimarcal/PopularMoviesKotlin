package gmp.thiago.apps.popularmovies.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import gmp.thiago.apps.popularmovies.PopularMoviesApplication
import gmp.thiago.apps.popularmovies.R
import gmp.thiago.apps.popularmovies.model.MovieListResult
import gmp.thiago.apps.popularmovies.model.Movies
import gmp.thiago.apps.popularmovies.retrofit.PopularMoviesApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesActivity : AppCompatActivity() {

    val app: PopularMoviesApplication by lazy {
        PopularMoviesApplication.instance
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        app.component.inject(this)

        var retrofit = app.retrofit

        var moviesCall = retrofit.create(PopularMoviesApi::class.java).getPopularMovies()
        moviesCall.enqueue(object : Callback<MovieListResult> {
            override fun onResponse(call: Call<MovieListResult>, response: Response<MovieListResult>) {
                Log.d("Thiago", "onResponse: ${response.isSuccessful} size: ${response.body()?.results?.size}")

            }

            override fun onFailure(call: Call<MovieListResult>, t: Throwable) {
                Log.d("Thiago", "onFailure ${t.message}")
            }
        })

        var sharedPreferences = app.sharedPreferences

        if (sharedPreferences.contains("teste")) {
            Log.d("Thiago", "teste: ${sharedPreferences.getString("teste", "vazio")}")
        } else {
            sharedPreferences.edit().putString("teste", "MyTestValue").apply()
        }
    }
}
