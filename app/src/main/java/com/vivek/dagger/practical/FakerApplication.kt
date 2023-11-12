package com.vivek.dagger.practical

import android.app.Application
import com.vivek.dagger.practical.di.ApplicationComponent
import com.vivek.dagger.practical.di.DaggerApplicationComponent

class FakerApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}