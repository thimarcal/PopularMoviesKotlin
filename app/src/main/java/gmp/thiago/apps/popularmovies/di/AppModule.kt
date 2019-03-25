package gmp.thiago.apps.popularmovies.di

import dagger.Module
import dagger.Provides
import gmp.thiago.apps.popularmovies.PopularMoviesApplication
import javax.inject.Singleton

@Module
class AppModule(val app: PopularMoviesApplication) {

    @Provides @Singleton
    fun provideAppModule() = app
}