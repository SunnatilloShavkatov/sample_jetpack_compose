package com.example.sample.di

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object NavigationModule {

    @Composable
    @Singleton
    fun provideNavHostController() = rememberNavController()
}