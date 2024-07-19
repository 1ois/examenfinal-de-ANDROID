package com.example.examenfinal.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.examenfinal.Models.Pokemon
import com.example.examenfinal.ui.theme.typeColors
import com.example.examenfinal.ui.theme.typeColorstext

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun PokemonDetailView(pokemon: Pokemon, navController: NavHostController) {
 Scaffold(
  topBar = { TopPokemon(pokemon,navController)},
  content = { innerPadding ->
   PokemonDetailContent(
    pokemon = pokemon,
    modifier = Modifier
     .fillMaxSize()
     .padding(innerPadding)
   )
  }
 )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable



fun TopPokemon(pokemon: Pokemon,navController: NavHostController){
 val backgroundColotext= typeColorstext[pokemon.type]?:Color.Gray
 val gradientColors = listOf(Color(0xFF9C27B0), Color(0xFF1875D1))
 TopAppBar(modifier = Modifier.fillMaxWidth().background(brush = Brush.horizontalGradient(gradientColors)),

  colors = TopAppBarDefaults.topAppBarColors(
   containerColor = Color.Transparent,
   titleContentColor = MaterialTheme.colorScheme.background
  ),
  title = {
   Text(text = pokemon.name, color = backgroundColotext)
  },

  navigationIcon = {
   IconButton(onClick = { navController.navigateUp() }) {
    Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
   }
  })

}
@Composable
fun PokemonDetailContent(
 pokemon: Pokemon,

 modifier: Modifier = Modifier
) {
 val backgroundColotext= typeColorstext[pokemon.type]?:Color.Gray
 val backgroundColor= typeColors[pokemon.type]?:Color.Gray
 Box(
  modifier = modifier
   .background(backgroundColor)
 ) {
  Column(horizontalAlignment = Alignment.CenterHorizontally,
   modifier = Modifier
    .fillMaxSize()
    .padding(16.dp)


  ) {
   Image(
    painter = rememberImagePainter(data = pokemon.imageUrl),
    contentDescription = null,
    modifier = Modifier
     .fillMaxWidth()
     .height(200.dp)
     .padding(bottom = 16.dp)
   )

   Text(text = pokemon.name, fontSize = 24.sp, fontWeight = FontWeight.Bold)

   Text(text = "Type: ${pokemon.type}", fontSize = 18.sp)
   Spacer(modifier = Modifier.padding(10.dp))
   Text(text = "Description: ${pokemon.description}", fontSize = 16.sp, fontWeight = FontWeight.ExtraBold, color = backgroundColotext)
   Spacer(modifier = Modifier.padding(10.dp))
   Row(){
    Box(contentAlignment = Alignment.Center,modifier = Modifier
     .clip(RoundedCornerShape(20.dp))
     .background(
      Color(
       0xFF009688
      )
     )
     .width(120.dp)){
     Text(text = "Attack: ${pokemon.attack}", fontSize = 16.sp, fontWeight = FontWeight.ExtraBold, color = backgroundColotext)
    }
    Spacer(modifier = Modifier.padding(10.dp))
    Box(contentAlignment = Alignment.Center,modifier = Modifier
     .clip(RoundedCornerShape(20.dp))
     .background(
      Color(
       0xFF009688
      )
     )
     .width(120.dp)){
     Text(text = "Defense: ${pokemon.defense}", fontSize = 16.sp, fontWeight = FontWeight.ExtraBold, color = backgroundColotext)
    }

   }

  }
 }
}

// fun PokemonDetailView(pokemon: Pokemon, navController: NavHostController) {
// Scaffold(
//  topBar = {
//   TopAppBar(
//    title = {
//     Text(text = pokemon.name, color = Color.White)
//    },
//   )
//  }
// ) { innerPadding ->
//  Box(
//   modifier = Modifier
//    .fillMaxSize()
//    .padding(innerPadding)
//    .background(Color.White)
//  ) {
//   Column(
//    modifier = Modifier
//     .fillMaxSize()
//     .padding(16.dp)
//
//   ) {
//    Image(
//     painter = rememberImagePainter(data = pokemon.imageUrl),
//     contentDescription = null,
//     modifier = Modifier
//      .fillMaxWidth()
//      .height(200.dp)
//      .padding(bottom = 16.dp)
//    )
//
//    Text(text = pokemon.name, fontSize = 24.sp, fontWeight = FontWeight.Bold)
//    Text(text = "Type: ${pokemon.type}", fontSize = 18.sp)
//    Text(text = "Description: ${pokemon.description}", fontSize = 16.sp)
//    Text(text = "Attack: ${pokemon.attack}", fontSize = 16.sp)
//    Text(text = "Defense: ${pokemon.defense}", fontSize = 16.sp)
//   }
//  }
// }
//}
