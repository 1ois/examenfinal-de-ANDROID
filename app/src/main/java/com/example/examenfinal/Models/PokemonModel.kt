package com.example.examenfinal.Models

import com.google.gson.annotations.SerializedName
import java.io.Serial



data class Pokemon(
    @SerializedName("attack")
    val attack: Int,
    @SerializedName("defense")
    val defense: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("evolutionChain")
    val evolutionChain: List<Evolution>,
    @SerializedName("height")
    val height: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("weight")
    val weight: Int
)

data class Evolution(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
)