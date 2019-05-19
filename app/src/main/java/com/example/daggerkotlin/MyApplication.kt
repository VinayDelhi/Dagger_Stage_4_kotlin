package com.example.daggerkotlin

import android.app.Application
import android.util.Log
import com.example.daggerkotlin.data.local.DatabaseService
import com.example.daggerkotlin.data.remote.NetworkService
import com.example.daggerkotlin.di.component.ApplicationComponent
import com.example.daggerkotlin.di.component.DaggerApplicationComponent
import com.example.daggerkotlin.di.module.ApplicationModule
import com.example.daggerkotlin.utils.NetworkHelper
import javax.inject.Inject

class MyApplication : Application(){

    @Inject
    lateinit var databaseService: DatabaseService

    @Inject
    lateinit var networkService: NetworkService

    @Inject
    lateinit var networkHelper: NetworkHelper

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        getDependencies()
    }

    fun getDependencies(){

        applicationComponent = DaggerApplicationComponent
                               .builder()
                               .applicationModule(ApplicationModule(this))
                               .build()

        applicationComponent.inject(this)

        Log.d("DEBUG", networkService.toString())
    }

}