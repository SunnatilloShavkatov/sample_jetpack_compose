package com.example.sample.routes

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sample.ui.main.MainScreen
import com.example.sample.ui.main.profile.settings.SettingsScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "main") {
        composable(Routes.main) {
            MainScreen(nav = navController)
        }
        composable(Routes.setting) {
            SettingsScreen(nav = navController)
        }
    }
}

class Routes {
    companion object {
        const val main: String = "main"
        const val setting: String = "settings"
    }
}

