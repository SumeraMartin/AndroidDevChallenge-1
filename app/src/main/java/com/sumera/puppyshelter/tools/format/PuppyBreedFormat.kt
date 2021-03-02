package com.sumera.puppyshelter.tools.format

import android.content.Context
import com.sumera.puppyshelter.R
import com.sumera.puppyshelter.ui.data.Breed

fun Breed.formatName(context: Context): String {
    val res = when (this) {
        Breed.POODLE -> R.string.breed__poodle
        Breed.GOLDEN_RETRIEVER -> R.string.breed__golden_retriever
        Breed.GERMAN_SHEPHERD -> R.string.breed__german_shepherd
        Breed.BULLDOG -> R.string.breed__bulldog
        Breed.BEAGLE -> R.string.breed__beagle
        Breed.PUG -> R.string.breed__pug
        Breed.DOGE -> R.string.breed__dodge
        Breed.POINTER -> R.string.breed__pointer
    }
    return context.getString(res)
}
