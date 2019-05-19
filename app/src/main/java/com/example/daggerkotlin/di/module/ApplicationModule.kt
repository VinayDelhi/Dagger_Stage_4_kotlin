package com.example.daggerkotlin.di.module

import android.app.Application
import android.content.Context
import com.example.daggerkotlin.MyApplication
import com.example.daggerkotlin.di.qualifier.ApplicationContext
import com.example.daggerkotlin.di.qualifier.DatabaseInfo
import com.example.daggerkotlin.di.qualifier.NetworkInfo
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val myApplication: MyApplication){

    @Provides
    @ApplicationContext
    fun provideContext() : Context{

        return myApplication;
    }

    @Provides
    @DatabaseInfo
    fun provideDatabaseName(): String{

        return "dummy_db"
    }


    @Provides
    @DatabaseInfo
    fun provideDatabaseVersion(): Int{

        return 1
    }

    @Provides
    @NetworkInfo
    fun provideNetworkApiKey(): String{

        return "SOME_API_KEY"
    }

}