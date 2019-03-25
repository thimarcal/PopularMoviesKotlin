package gmp.thiago.apps.popularmovies

import android.app.Application
import gmp.thiago.apps.popularmovies.di.AppComponent
import gmp.thiago.apps.popularmovies.di.DaggerAppComponent

class PopularMoviesApplication : Application () {

    init{
        instance = this
    }

    val component : AppComponent by lazy {
        DaggerAppComponent.create()
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