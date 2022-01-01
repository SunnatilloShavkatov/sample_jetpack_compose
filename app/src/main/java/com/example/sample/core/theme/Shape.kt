package com.example.sample.core.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp)
)

class AppShape {
    companion object {
        val small = RoundedCornerShape(4.dp)
        val cornerShape8 = RoundedCornerShape(8.dp)
        val medium = RoundedCornerShape(4.dp)
        val large = RoundedCornerShape(0.dp)
    }
}