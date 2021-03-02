package com.sumera.puppyshelter.coreactor.reducer

import com.sumera.puppyshelter.coreactor.contract.state.State

abstract class Reducer<STATE: State> {

    abstract fun reduce(state: STATE): STATE
}
