package gmp.thiago.apps.popularmovies.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MoviesDao {
    @Query("SELECT * FROM movies")
    fun getFavorites() : LiveData<List<Movies>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addToFavorites(movie: Movies)

    @Delete
    fun removeFromFavorites(movie: Movies)
}