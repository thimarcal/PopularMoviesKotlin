package gmp.thiago.apps.popularmovies.retrofit

import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface PopularMoviesApi {

    // TODO: Here we'll place all the needed @Gets

    companion object Factory{
        fun create(baseUrl: String) : Retrofit {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build()
        }
    }
}