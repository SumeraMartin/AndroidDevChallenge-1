package com.sumera.puppyshelter.ui.screens.puppylist.logic.state

import com.sumera.puppyshelter.coreactor.contract.state.State
import com.sumera.puppyshelter.ui.data.Puppy
import com.sumera.puppyshelter.ui.data.generic.LoadingState

data class PuppyListState(
    val puppiesState: LoadingState<List<Puppy>>,
    val filter: FilterState,
) : State {

    companion object {
        val DEFAULT = PuppyListState(
            puppiesState = LoadingState.Loading,
            filter = FilterState.DEFAULT,
        )
    }
}
