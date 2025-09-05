package com.example.bodyfit.core.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = NeonGreen,
    onPrimary = Black,         // texto em cima do botão verde
    background = Black,
    onBackground = White,
    surface = Black,
    onSurface = White,
)

@Composable
fun BodyFitTheme(content: @Composable () -> Unit){
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}


