package gmp.thiago.apps.popularmovies.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.room.Room
import dagger.Module
import dagger.Provides
import gmp.thiago.apps.popularmovies.data.MoviesDao
import gmp.thiago.apps.popularmovies.datasource.DataRepository
import gmp.thiago.apps.popularmovies.repository.MoviesDatabase
import javax.inject.Singleton

@Module
class DataModule(private val context: Context) {

    private var moviesDatabase : MoviesDatabase =
        Room.databaseBuilder(context, MoviesDatabase::class.java, MoviesDatabase.DATABASE_NAME).build()

    @Provides
    fun provideSharedPreferences(): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    @Singleton
    @Provides
    fun provideRoomDatabase(): MoviesDatabase {
        return moviesDatabase
    }

    @Singleton
    @Provides
    fun provideMoviesDao(moviesDatabase : MoviesDatabase) : MoviesDao {
        return moviesDatabase.moviesDao()
    }

    @Singleton
    @Provides
    fun provideDataRepository(moviesDatabase: MoviesDatabase) : DataRepository {
        return DataRepository(moviesDatabase)
    }
}