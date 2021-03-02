package com.sumera.puppyshelter.ui.screens.puppylist.logic.state

import com.sumera.puppyshelter.ui.data.Breed

data class FilterState(
    val breeds: List<Breed>,
) {

    val visibleBreeds: List<Breed> get() = if (breeds.isNotEmpty()) breeds else Breed.values().toList()

    companion object {
        val DEFAULT = FilterState(
            breeds = emptyList()
        )
    }
}
