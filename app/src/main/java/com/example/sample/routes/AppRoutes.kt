package com.example.sample.routes

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sample.di.NavigationModule
import com.example.sample.ui.main.MainScreen
import com.example.sample.ui.main.profile.settings.SettingsScreen

@Composable
fun AppNavigation() {
    val routes = NavigationModule.provideNavHostController()
    NavHost(routes, startDestination = AppRoutes.main) {
        composable(AppRoutes.main) {
            MainScreen(routes)
        }
        composable(AppRoutes.setting) {
            SettingsScreen(routes)
        }
    }
}

object AppRoutes {
    const val main: String = "main"
    const val setting: String = "settings"
}

