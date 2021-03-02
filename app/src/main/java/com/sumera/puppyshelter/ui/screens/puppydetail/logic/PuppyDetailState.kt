package com.sumera.puppyshelter.ui.screens.puppydetail.logic

import com.sumera.puppyshelter.coreactor.contract.state.State
import com.sumera.puppyshelter.ui.data.Puppy

data class PuppyDetailState(
    val puppy: Puppy?
) : State {
    companion object {
        val DEFAULT = PuppyDetailState(
            puppy = null
        )
    }
}
