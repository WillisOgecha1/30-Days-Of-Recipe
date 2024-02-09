package com.example.cuisine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cuisine.model.CuisineRepository
import com.example.cuisine.ui.theme.CuisineTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CuisineTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val recipeList =CuisineRepository.days
                   RecipeList(recipeList = recipeList)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecipeListPreview() {
    CuisineTheme {
        val recipeList =CuisineRepository.days
        RecipeList(recipeList =recipeList )
    }
}