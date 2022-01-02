package com.example.sample.ui.main.favourite

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun FavouriteScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Favourite") },
                elevation = 1.dp
            )
        },
        content = { Text(" Favourite ") },
    )
}
