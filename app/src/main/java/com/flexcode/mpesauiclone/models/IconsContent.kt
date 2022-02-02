package com.flexcode.mpesauiclone.models


import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class IconsContent(
    val id :Int = 0,
    val title: String,
    val color: Color,
    @DrawableRes val iconId: Int
    )