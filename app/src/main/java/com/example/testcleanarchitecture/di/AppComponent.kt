package com.example.testcleanarchitecture.di

import com.example.testcleanarchitecture.presentation.MainActivity
import dagger.Component

@Component (modules = [AppModule::class, DataModule::class, DomainModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}