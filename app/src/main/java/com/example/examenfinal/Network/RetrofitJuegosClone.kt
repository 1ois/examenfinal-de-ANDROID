/*package com.example.examenfinal.Network

import com.example.examenfinal.Utils.Util
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitJuegosClone {
    val retrofit:APIPokemon by lazy{
        Retrofit
            .Builder()
            .baseUrl(Util.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIPokemon::class.java)
    }
}*/