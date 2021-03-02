package com.sumera.puppyshelter.coreactor.contract.reducer

import com.sumera.puppyshelter.coreactor.contract.state.State
import com.sumera.puppyshelter.coreactor.reducer.Reducer

fun <STATE : State> reducer(reducerAction: (STATE) -> STATE): Reducer<STATE> {
    return object : Reducer<STATE>() {
        override fun reduce(state: STATE): STATE  = reducerAction(state)
    }
}
