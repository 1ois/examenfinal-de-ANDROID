package com.example.examenfinal.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examenfinal.Models.Pokemon
import com.example.examenfinal.Network.RetrofitJuegos
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class PokemonViewModel : ViewModel() {
    private val _juegos = MutableStateFlow<List<Pokemon>>(emptyList())
    val juegos = _juegos.asStateFlow()

    init {
        mostrarJuegos()
    }

    private fun mostrarJuegos() {
        viewModelScope.launch {
            try {
                val response = RetrofitJuegos.retrofit.obtenerJuegos()
                if (response.isSuccessful) {
                    response.body()?.let { pokemonList ->
                        Log.d("PokemonViewModel", "Response: $pokemonList")

                        // Filtra los valores null de la lista
                        _juegos.value = pokemonList.filterNotNull()
                    }
                } else {
                    Log.e("PokemonViewModel", "Error: ${response.errorBody()?.string()}")
                    _juegos.value = emptyList()
                }
            } catch (e: Exception) {
                Log.e("PokemonViewModel", "Exception: ${e.message}")
            }
        }
    }

}
