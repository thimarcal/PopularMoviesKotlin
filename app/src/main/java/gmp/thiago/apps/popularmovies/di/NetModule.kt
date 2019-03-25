package gmp.thiago.apps.popularmovies.di

import dagger.Module
import gmp.thiago.apps.popularmovies.retrofit.PopularMoviesApi
import retrofit2.Retrofit

@Module
class NetModule(var baseUrl: String) {

    fun provideRetrofit(baseUrl: String) : Retrofit {
        return PopularMoviesApi.create(baseUrl)
    }
}