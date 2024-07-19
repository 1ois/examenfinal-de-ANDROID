package com.example.examenfinal.Navigation

sealed class AppView(val router:String) {
    object  Pokemones:AppView("pokemones")
    object  PokemonDetail:AppView("pokemondetail")
}