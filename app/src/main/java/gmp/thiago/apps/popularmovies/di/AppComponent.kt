package gmp.thiago.apps.popularmovies.di

import dagger.Component
import gmp.thiago.apps.popularmovies.PopularMoviesApplication

@Component (modules = [AppModule::class, NetModule::class])
interface AppComponent {
    fun inject(component: PopularMoviesApplication)
}