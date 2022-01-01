package com.example.sample.core.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = AppColor.white,
    primaryVariant = AppColor.purple500,
    secondary = AppColor.teal200,
    background = AppColor.background,
    surface = AppColor.white,
    onPrimary = AppColor.black,
    onSecondary = AppColor.black,
    onBackground = AppColor.black,
    onSurface = AppColor.black,
)

@SuppressLint("ConflictingOnColor")
private val LightColorPalette = lightColors(
    primary = AppColor.white,
    primaryVariant = AppColor.purple500,
    secondary = AppColor.teal200,
    background = AppColor.background,
    surface = AppColor.white,
    onPrimary = AppColor.black,
    onSecondary = AppColor.black,
    onBackground = AppColor.black,
    onSurface = AppColor.black,
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}