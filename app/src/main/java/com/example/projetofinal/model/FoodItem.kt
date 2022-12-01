package com.example.projetofinal.model

data class FoodItem(
    val name: String,
    val carbohydrate: Double,
    val protein: Double,
    val fat: Double,
    val calories: Double
) {
    fun caloriesToString(): String = calories.toString()
}