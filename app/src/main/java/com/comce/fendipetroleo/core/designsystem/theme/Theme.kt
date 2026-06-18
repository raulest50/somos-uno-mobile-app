package com.comce.fendipetroleo.core.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = ComceGreen,
    onPrimary = ComceInkDark,
    secondary = ComceBlue,
    onSecondary = ComceWhite,
    tertiary = ComceGreenSoft,
    onTertiary = ComceInkDark,
    background = ComceDarkSurface,
    onBackground = ComceWhite,
    surface = ComceDarkSurface,
    onSurface = ComceWhite,
    surfaceVariant = ComceDarkSurfaceVariant,
    onSurfaceVariant = ComceSurfaceVariant,
    outline = ComceGray
)

private val LightColorScheme = lightColorScheme(
    primary = ComceBlue,
    onPrimary = ComceWhite,
    secondary = ComceGreen,
    onSecondary = ComceInkDark,
    tertiary = ComceInk,
    onTertiary = ComceWhite,
    background = ComceSurface,
    onBackground = ComceInk,
    surface = ComceWhite,
    onSurface = ComceInk,
    surfaceVariant = ComceSurfaceVariant,
    onSurfaceVariant = ComceGray,
    outline = ComceOutline
)

@Composable
fun ComceFendipetroleoMobileAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
