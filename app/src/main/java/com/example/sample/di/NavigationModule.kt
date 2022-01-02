package com.example.sample.di

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NavigationModule {

    @Singleton
    @Composable
    fun provideNavHostController() = rememberNavController()
}