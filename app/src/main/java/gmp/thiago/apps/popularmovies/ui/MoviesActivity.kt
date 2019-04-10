package gmp.thiago.apps.popularmovies.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import gmp.thiago.apps.popularmovies.PopularMoviesApplication
import gmp.thiago.apps.popularmovies.R
import gmp.thiago.apps.popularmovies.data.Movies
import gmp.thiago.apps.popularmovies.model.MovieListResult
import gmp.thiago.apps.popularmovies.retrofit.PopularMoviesApi
import kotlinx.coroutines.*
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

        // Testing Retrofit Injection
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

        // Testing SharedPreferences Injection
        var sharedPreferences = app.sharedPreferences

        if (sharedPreferences.contains("teste")) {
            Log.d("Thiago", "teste: ${sharedPreferences.getString("teste", "vazio")}")
        } else {
            sharedPreferences.edit().putString("teste", "MyTestValue").apply()
        }

        // Testing Room Injection with Kotlin co-routines
        val uiScope = CoroutineScope(Dispatchers.Main)
        val bgDispatcher : CoroutineDispatcher  = Dispatchers.IO

        uiScope.launch {

            withContext(bgDispatcher) {
                var dataRepository = app.dataRepository
                var movie = Movies(
                    0, "Teste", "Teste", "pt", "Teste de filme", 0.0, "teste",
                    "2018", 8.8, 50, false, "..", false
                )
                dataRepository.insertMovie(movie)

            }
            Log.d("Thiago", "movie inserted")

        }

    }
}
