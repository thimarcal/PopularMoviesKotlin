package gmp.thiago.apps.popularmovies.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import gmp.thiago.apps.popularmovies.data.Movies
import gmp.thiago.apps.popularmovies.data.MoviesDao

@Database(entities = [Movies::class], version = MoviesDatabase.DATABASE_VERSION)
abstract class MoviesDatabase : RoomDatabase() {
    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "movies-database"
    }

    abstract fun moviesDao() : MoviesDao
}