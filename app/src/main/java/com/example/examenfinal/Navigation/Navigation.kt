package com.example.examenfinal.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.examenfinal.View.PokemonDetailView

import com.example.examenfinal.View.VideoJuegosView
import com.example.examenfinal.ViewModel.PokemonViewModel

@Composable
fun NavigationView(modifier: Modifier,viewModel:PokemonViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppView.Pokemones.router) {
        composable(AppView.Pokemones.router) {
            VideoJuegosView(
                navController = navController,
                viewModel
            )
        }
        composable("${AppView.PokemonDetail.router}/{pokemonId}") { backStackEntry ->
            val pokemonId = backStackEntry.arguments?.getString("pokemonId")?.toIntOrNull()
            val pokemon = viewModel.juegos.collectAsState().value.find { it.id == pokemonId }
            pokemon?.let {
                PokemonDetailView(pokemon = it, navController = navController)
            }
        }

    }


}