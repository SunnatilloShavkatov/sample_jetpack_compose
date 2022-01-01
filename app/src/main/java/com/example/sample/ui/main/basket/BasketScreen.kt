package com.example.sample.ui.main.basket

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun BasketScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Basket") },
                backgroundColor = MaterialTheme.colors.primary, elevation = 0.dp
            )
        },
        drawerContent = { Text(text = "Basket") },
        content = { Text("Content") },
        bottomBar = { BottomAppBar(backgroundColor = MaterialTheme.colors.primary) { Text("Bottom App Bar") } }
    )

}