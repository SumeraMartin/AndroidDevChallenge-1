package com.sumera.puppyshelter.ui.screens.puppylist.logic.reducers

import com.sumera.puppyshelter.coreactor.reducer.Reducer
import com.sumera.puppyshelter.ui.data.Breed
import com.sumera.puppyshelter.ui.screens.puppylist.logic.state.PuppyListState

class ToggleBreedFilterReducer(private val breed: Breed) : Reducer<PuppyListState>() {
    override fun reduce(state: PuppyListState): PuppyListState {
        val breeds = state.filter.breeds.toMutableList()
        if (breed in breeds) {
            breeds.remove(breed)
        } else {
            breeds.add(breed)
        }
        return state.copy(filter = state.filter.copy(breeds = breeds))
    }
}