package com.example.daggerkotlin.di.component

import com.example.daggerkotlin.di.module.FragmentModule
import com.example.daggerkotlin.di.scope.FragmentScope
import com.example.daggerkotlin.ui.home.HomeFragment
import dagger.Component

@FragmentScope
@Component(dependencies = [(ApplicationComponent::class)], modules = [(FragmentModule::class)])
interface FragmentComponent {

    fun inject(homeFragment: HomeFragment)
}