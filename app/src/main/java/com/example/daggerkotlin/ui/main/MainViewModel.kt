package com.example.daggerkotlin.ui.main

import com.example.daggerkotlin.data.local.DatabaseService
import com.example.daggerkotlin.data.remote.NetworkService
import com.example.daggerkotlin.di.scope.ActivityScope
import javax.inject.Inject
import javax.inject.Singleton

@ActivityScope
class MainViewModel @Inject constructor(private val databaseService: DatabaseService, private val networkService: NetworkService){


      fun getSomeData():String{
          return "${databaseService.getDummyData()} ${networkService.getDummyData()}"
      }

}