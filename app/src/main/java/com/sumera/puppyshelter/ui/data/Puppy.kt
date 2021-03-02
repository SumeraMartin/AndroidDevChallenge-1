package com.sumera.puppyshelter.ui.data

data class Puppy(
    val id: String,
    val name: String,
    val breed: Breed,
    val imageUrl: String,
    val ageWeeks: Int,
    val distanceKm: Float,
    val description: String,
)
