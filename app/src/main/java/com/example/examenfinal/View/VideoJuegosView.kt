package com.example.examenfinal.View


import android.media.Image
import androidx.compose.foundation.*

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid

import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape


import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text


import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.examenfinal.Models.Evolution
import com.example.examenfinal.Models.Pokemon
import com.example.examenfinal.Navigation.AppView
import com.example.examenfinal.ViewModel.PokemonViewModel


import okhttp3.internal.wait


@Composable
fun VideoJuegosView(navController: NavHostController, viewModel: PokemonViewModel)
{
    Scaffold (
        topBar = {TopApi(navController)},
        content = { innerPadding->
            Surface (
                modifier = Modifier.padding(innerPadding))
            { contentApi(navController,viewModel) }
        }
    )


}
@Composable
fun contentApi(navController: NavHostController,viewModel: PokemonViewModel) {
    Box(modifier = Modifier.background(Color.White)){
        val juegos by viewModel.juegos.collectAsState()
        LazyVerticalGrid(
            contentPadding = PaddingValues(5.dp),
            columns = GridCells.Fixed(3),
            modifier = Modifier


        ) {
            items(juegos.size) { index ->
                val juego = juegos[index]
                // Calcular el índice de fila
                val rowIndex = index / 3
                val backgroundColor = getColorForRow(rowIndex)
                Column(horizontalAlignment = Alignment.CenterHorizontally ,
                    modifier = Modifier.padding(bottom = 5.dp) ) {
                    CardJuego(juegos = juego,backgroundColor=backgroundColor,navController=navController)
                    Spacer(modifier = Modifier.height(5.dp))
                }

                // Text(text=it.)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopApi(navController: NavHostController) {
    val gradientColors = listOf(Color(0xFF9C27B0), Color(0xFF1875D1))
    TopAppBar(modifier = Modifier.fillMaxWidth().background(brush = Brush.horizontalGradient(gradientColors)),

        colors =TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = MaterialTheme.colorScheme.background
        )
        ,
        title = {

            Text(
                text = "POKEMON ALDO",
                textAlign = TextAlign.Center,
                modifier=Modifier.fillMaxWidth())

        }
    )
}

@Composable
fun CardJuego(
    juegos: Pokemon,
    backgroundColor:Color,
    navController: NavHostController
)
{
    Card(
        shape = RoundedCornerShape(4.dp),
        modifier= Modifier
            .padding(bottom = 10.dp)
            .shadow(4.dp)
            .border(2.dp, color = Color.White)
            .clickable {   navController.navigate("${AppView.PokemonDetail.router}/${juegos.id}")}
    ){

        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.background(backgroundColor)) {
            InicioImagen(imagen=juegos.imageUrl, backgroundColor = backgroundColor)

            Spacer(modifier =Modifier.height(2.dp))
            Box(contentAlignment = Alignment.Center,modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(
                    Color(
                        0xFF009688
                    )
                )
                .width(97.dp)){
                Text(
                    text = juegos.name,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFFFFFFFF),
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,



                    )
            }


            Text(
                text = juegos.type,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                modifier = Modifier.padding(bottom = 4.dp),
                fontSize = 15.sp,
                textAlign = TextAlign.Center


            )
        }

    }
}

@Composable
fun InicioImagen(imagen: String,backgroundColor: Color) {
    val painter = rememberImagePainter(data = imagen)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .background(backgroundColor)

    ) {
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp) // Ajustar el padding para centrar la imagen
        )
    }
}
fun getColorForRow(rowIndex: Int): Color {
    return when (rowIndex % 6) {
        0 -> Color.Green
        1 -> Color.Red
        2 -> Color.Blue
        3 -> Color.Green
        4-> Color.Yellow
        5-> Color.Gray
        else -> Color.Gray // Por si acaso, aunque no debería llegar aquí.
    }
}
/*val juegos by viewModel.juegos.collectAsState()
LazyColumn(
modifier= Modifier
.padding(top = 2.dp)
.background(Color(0xFF8BC34A))
) {
    items(juegos){
        CardJuego(juegos=it) {}
        Text(text = it.name
            , fontWeight = FontWeight.ExtraBold
            , color = Color.White
            , modifier = Modifier.padding(start = 12.dp)
        )
        // Text(text=it.)

    }
}
}este es mi codigo de android jack compose , en este codigo se me muestra una columan de imagenes pero quiero que sea de 3 columnas
*/