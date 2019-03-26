package gmp.thiago.apps.popularmovies

import android.app.Application
import gmp.thiago.apps.popularmovies.di.AppComponent
import gmp.thiago.apps.popularmovies.di.DaggerAppComponent
import gmp.thiago.apps.popularmovies.di.NetModule
import gmp.thiago.apps.popularmovies.model.Movies
import gmp.thiago.apps.popularmovies.retrofit.PopularMoviesApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class PopularMoviesApplication : Application () {

    init{
        instance = this
    }

    @Inject
    lateinit var retrofit: Retrofit

    val component : AppComponent by lazy {
        DaggerAppComponent.builder()
            .netModule(NetModule("https://api.themoviedb.org/3/movie/"))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }

    companion object {
        lateinit var instance : PopularMoviesApplication
                private set
    }
}