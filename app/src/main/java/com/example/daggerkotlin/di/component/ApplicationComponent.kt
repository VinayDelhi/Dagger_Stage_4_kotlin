package com.example.daggerkotlin.di.component

import android.content.Context
import com.example.daggerkotlin.MyApplication
import com.example.daggerkotlin.data.local.DatabaseService
import com.example.daggerkotlin.data.remote.NetworkService
import com.example.daggerkotlin.di.module.ApplicationModule
import com.example.daggerkotlin.di.qualifier.ApplicationContext
import com.example.daggerkotlin.utils.NetworkHelper
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(ApplicationModule:: class)])
interface ApplicationComponent {

    fun inject(myApplication: MyApplication)

    @ApplicationContext
    fun getContext() : Context

    fun getDatabaseService(): DatabaseService
    fun getNetworkService(): NetworkService
    fun getNetworkHelper(): NetworkHelper
}