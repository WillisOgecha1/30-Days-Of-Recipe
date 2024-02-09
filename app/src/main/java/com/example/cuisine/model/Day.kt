package com.example.cuisine.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Day(
   @StringRes val day :Int,
   @StringRes val food : Int,
   @DrawableRes val imageRes : Int,
   @StringRes val foodDescription: Int
)
