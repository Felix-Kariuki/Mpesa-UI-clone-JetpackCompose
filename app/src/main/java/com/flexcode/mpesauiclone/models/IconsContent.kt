package com.flexcode.mpesauiclone.models

import android.graphics.Color
import androidx.annotation.DrawableRes

data class IconsContent(
    val title: String,
    val color: androidx.compose.ui.graphics.Color,
    @DrawableRes val iconId: Int
    )