package org.compose_projects.socialLocal.core.ui

import androidx.compose.ui.graphics.Color

internal object SLTheme {
    val defaultStyle: SLThemeConfig
        get() = object: SLThemeConfig{
            override val BackgroundColor: Color
                get() = SL_theme_default_BackgroundColor
            override val TextTopAppBarColor: Color
                get() = SL_theme_default_TextTopAppBarColor
            override val BackgroundTopAppBarColor: Color
                get() = SL_theme_default_BackgroundTopAppBarColor
            override val BackgroundBottomAppBarColor: Color
                get() = SL_theme_default_BackgroundBottomAppBarColor
            override val IconSelectedBottomAppBarColor: Color
                get() = SL_theme_default_IconSelectedBottomAppBarColor
            override val IconUnSelectedBottomAppBarColor: Color
                get() = SL_theme_default_IconUnSelectedBottomAppBarColor
            override val BackgroundIconButtonAppBarColor: Color
                get() = SL_theme_default_backgroundIconBottomAppBarColor
            override val BackgroundBottomSheetsColor: Color
                get() = SL_theme_default_BackgroundBottomSheetsColor
            override val IconsColor: Color
                get() = SL_theme_default_IconsColor
            override val BackgroundButtonsColor: Color
                get() = SL_theme_default_BackgroundButtonsColor
            override val TextsColor: Color
                get() = SL_theme_default_TextsColor
        }
}