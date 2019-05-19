package com.example.daggerkotlin.di.component

import com.example.daggerkotlin.di.module.ActivityModule
import com.example.daggerkotlin.di.scope.ActivityScope
import com.example.daggerkotlin.ui.main.MainActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [(ApplicationComponent ::class)], modules = [(ActivityModule:: class)])
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)
}