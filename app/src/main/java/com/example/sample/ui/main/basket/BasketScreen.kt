package com.example.sample.ui.main.basket

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun BasketScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Basket") },
                backgroundColor = MaterialTheme.colors.primary, elevation = 0.dp
            )
        },
        content = { Text(" Basket ") },
    )

}