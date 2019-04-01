package gmp.thiago.apps.popularmovies.di

import dagger.Component
import gmp.thiago.apps.popularmovies.PopularMoviesApplication
import gmp.thiago.apps.popularmovies.ui.MoviesActivity
import javax.inject.Singleton

@Component (modules = [AppModule::class, NetModule::class, DataModule::class])
@Singleton
interface AppComponent {
    fun inject(component: PopularMoviesApplication)
    fun inject(moviesActivity: MoviesActivity)
}