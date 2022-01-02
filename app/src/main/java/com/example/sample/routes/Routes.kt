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
    NavHost(routes, startDestination = Routes.main) {
        composable(Routes.main) {
            MainScreen(routes)
        }
        composable(Routes.setting) {
            SettingsScreen(routes)
        }
    }
}

object Routes {
    const val main: String = "main"
    const val setting: String = "settings"
}

