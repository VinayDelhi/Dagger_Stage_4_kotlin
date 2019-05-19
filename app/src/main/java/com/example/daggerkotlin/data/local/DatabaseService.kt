package com.example.daggerkotlin.data.local

import android.content.Context
import com.example.daggerkotlin.di.qualifier.ApplicationContext
import com.example.daggerkotlin.di.qualifier.DatabaseInfo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DatabaseService @Inject constructor(@ApplicationContext val context: Context, @DatabaseInfo val databaseName : String, @DatabaseInfo val version : Int){


    fun getDummyData(): String{

        return "DATABASE_DUMMY_DATA"
    }
}