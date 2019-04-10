package gmp.thiago.apps.popularmovies

import android.app.Application
import android.content.SharedPreferences
import gmp.thiago.apps.popularmovies.datasource.DataRepository
import gmp.thiago.apps.popularmovies.di.AppComponent
import gmp.thiago.apps.popularmovies.di.DaggerAppComponent
import gmp.thiago.apps.popularmovies.di.DataModule
import gmp.thiago.apps.popularmovies.di.NetModule
import retrofit2.Retrofit
import javax.inject.Inject

class PopularMoviesApplication : Application () {

    init{
        instance = this
    }

    @Inject
    lateinit var retrofit: Retrofit

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    @Inject
    lateinit var dataRepository: DataRepository

    val component : AppComponent by lazy {
        DaggerAppComponent.builder()
            .netModule(NetModule("https://api.themoviedb.org/3/movie/"))
            .dataModule(DataModule(instance))
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