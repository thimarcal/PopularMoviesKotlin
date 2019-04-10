package gmp.thiago.apps.popularmovies.datasource

import androidx.lifecycle.LiveData
import gmp.thiago.apps.popularmovies.data.Movies
import gmp.thiago.apps.popularmovies.repository.MoviesDatabase

class DataRepository (val moviesDatabase: MoviesDatabase) {

    fun insertMovie(movie : Movies) {
        moviesDatabase.moviesDao().addToFavorites(movie)
    }

    fun getFavoriteMovies() : LiveData<List<Movies>> {
        return moviesDatabase.moviesDao().getFavorites()
    }
}