package gmp.thiago.apps.popularmovies.di

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides

@Module
class DataModule(val context: Context) {

    @Provides
    fun provideSharedPreferences() : SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }
}