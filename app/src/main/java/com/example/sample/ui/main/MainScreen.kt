package com.example.sample.ui.main

import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.sample.*
import com.example.sample.ui.main.basket.BasketScreen
import com.example.sample.ui.main.favourite.FavouriteScreen
import com.example.sample.ui.main.home.HomeScreen
import com.example.sample.ui.main.profile.ProfileScreen

@Composable
fun MainScreen(nav: NavHostController) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigation(navController = navController) }
    ) {
        NavigationMainGraph(navController = navController, nav = nav)
    }
}

@Composable
fun NavigationMainGraph(navController: NavHostController, nav: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Home.screen_route) {
        composable(BottomNavItem.Home.screen_route) {
            HomeScreen()
        }
        composable(BottomNavItem.Basket.screen_route) {
            BasketScreen()
        }
        composable(BottomNavItem.Favourite.screen_route) {
            FavouriteScreen()
        }
        composable(BottomNavItem.Profile.screen_route) {
            ProfileScreen(navController = nav)
        }
    }
}

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Basket,
        BottomNavItem.Favourite,
        BottomNavItem.Profile,
    )
    androidx.compose.material.BottomNavigation(
        backgroundColor = colorResource(id = R.color.teal_200),
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 9.sp
                    )
                },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

sealed class BottomNavItem(var title: String, var icon: Int, var screen_route: String) {
    object Home : BottomNavItem("Home", R.drawable.ic_active_home, "home")
    object Basket : BottomNavItem("My Network", R.drawable.ic_shopping_bag, "basket")
    object Favourite : BottomNavItem("Post", R.drawable.ic_heart, "favourite")
    object Profile : BottomNavItem("Notification", R.drawable.ic_user, "notification")
}
