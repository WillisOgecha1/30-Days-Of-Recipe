package com.example.cuisine

import android.content.DialogInterface.OnClickListener
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cuisine.model.Day
import com.example.cuisine.ui.theme.CuisineTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeList(
    modifier: Modifier=Modifier,
    recipeList: List<Day>
) {
    var isVisible by remember { mutableStateOf(true) }
  // var recipeVisibilityState by remember {
  //     mutableStateOf(List(recipeList.size){false})
 //  }


    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(
                    text = "30 DAYS OF RECIPE",
                    style = MaterialTheme.typography.displayMedium,
                    color = MaterialTheme.colorScheme.error
                )
            })
        }
    ){ it ->
        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(),
            exit = fadeOut(),

        ){
            LazyColumn(contentPadding = it, modifier = Modifier.padding(8.dp)){
                itemsIndexed(recipeList){ index, day ->
                    DayRecipe(dayNum = day.day
                        , foodId =day.food ,
                        image = day.imageRes,
                        foodDesc = day.foodDescription,
                      //  isTextVisible = recipeVisibilityState[index],
                     /*   onRecipeClicked ={
                            recipeVisibilityState  = recipeVisibilityState.toMutableList().apply {
                                // Toggle visibility for the clicked recipe
                                this[index] = !this[index]
                            }
                        }*/
                    )

                }
            }
        }


        
    }
}

@Composable
fun DayRecipe(
    modifier: Modifier = Modifier,
   @StringRes dayNum : Int,
    @StringRes foodId : Int,
    @DrawableRes image : Int,
    @StringRes foodDesc : Int,
   // isTextVisible: Boolean,
   // onClickListener: OnClickListener
    
) {

    Card(
        elevation = CardDefaults.cardElevation(3.dp),
       modifier = Modifier.padding(16.dp),
    ){
        Column(
            modifier= modifier
                .fillMaxSize()
                .padding(16.dp)

        ) {
            Text(text = stringResource(id = dayNum),
                style = MaterialTheme.typography.displayMedium
            )
            Text(text = stringResource(id = foodId),
                style = MaterialTheme.typography.displayLarge
            )
            Image(painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier//fillMaxWidth()
                        )
          // if (isTextVisible) {
               Text(
                   text = stringResource(id = foodDesc),
                   style = MaterialTheme.typography.bodyLarge
               )
           }
        }

    //}

}
/*
@Preview
@Composable
fun DayRecipePreview() {
    CuisineTheme {
        var isVisible by remember { mutableStateOf(true) }
        var recipeVisibilityState by remember {
            mutableStateOf(List(recipeList.size){false})
        }

        DayRecipe( dayNum = R.string.day_1,
            foodId = R.string.day1, image = R.drawable.ugali___sukuma_wiki,
            foodDesc =R.string.day_1_description ,
            isTextVisible=,
            onRecipeClicked =
        )


    }

}*/