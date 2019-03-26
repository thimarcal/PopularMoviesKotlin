package gmp.thiago.apps.popularmovies.di

import dagger.Module
import dagger.Provides
import gmp.thiago.apps.popularmovies.retrofit.PopularMoviesApi
import retrofit2.Retrofit

@Module
class NetModule(private val baseUrl : String) {

    @Provides
    fun provideRetrofit() : Retrofit {
        return PopularMoviesApi.create(baseUrl)
    }
}