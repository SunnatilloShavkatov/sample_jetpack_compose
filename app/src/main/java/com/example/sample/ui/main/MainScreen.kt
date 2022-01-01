package com.example.sample.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.sample.*
import com.example.sample.core.theme.AppColor
import com.example.sample.ui.main.basket.BasketScreen
import com.example.sample.ui.main.favourite.FavouriteScreen
import com.example.sample.ui.main.home.HomeScreen
import com.example.sample.ui.main.profile.ProfileScreen

@Composable
fun MainScreen(nav: NavHostController) {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.background(color = AppColor.background),
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
        backgroundColor = AppColor.white,
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    if (currentRoute == item.screen_route) {
                        Icon(
                            painterResource(id = item.activeIcon),
                            contentDescription = item.title,
                            modifier = Modifier.padding(top = 3.dp, bottom = 3.dp)
                        )
                    } else {

                        Icon(
                            painterResource(id = item.icon),
                            contentDescription = item.title,
                            modifier = Modifier.padding(top = 3.dp, bottom = 3.dp)
                        )
                    }
                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.W400,
                        modifier = Modifier.padding(bottom = 3.dp, top = 3.dp)
                    )
                },
                selectedContentColor = AppColor.blue,
                unselectedContentColor = AppColor.grey,
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

sealed class BottomNavItem(
    var title: String,
    var icon: Int,
    var activeIcon: Int,
    var screen_route: String
) {
    object Home :
        BottomNavItem("Home", R.drawable.ic_home, R.drawable.ic_active_home, "home")

    object Basket :
        BottomNavItem(
            "Basket",
            R.drawable.ic_shopping_bag,
            R.drawable.ic_active_shopping_bag,
            "basket",
        )

    object Favourite :
        BottomNavItem("Favourite", R.drawable.ic_heart, R.drawable.ic_active_heart, "favourite")

    object Profile :
        BottomNavItem("Profile", R.drawable.ic_user, R.drawable.ic_active_user, "profile")
}
