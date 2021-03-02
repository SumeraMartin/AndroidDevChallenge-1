package com.sumera.puppyshelter.coreactor.log.impl

import com.sumera.puppyshelter.coreactor.action.Action
import com.sumera.puppyshelter.coreactor.reducer.Reducer
import com.sumera.puppyshelter.coreactor.contract.state.State
import com.sumera.puppyshelter.coreactor.lifecycle.LifecycleState
import com.sumera.puppyshelter.coreactor.log.CoreactorLogger

open class SimpleLogger<STATE : State> : CoreactorLogger<STATE> {

    override fun onState(state: STATE) {
        // NoOp
    }

    override fun onStateDispatchedToView(state: STATE) {
        // NoOp
    }

    override fun onAction(action: Action<STATE>) {
        // NoOp
    }

    override fun onLifecycle(lifecycleState: LifecycleState) {
        // NoOp
    }

    override fun onReducer(oldState: STATE, reducer: Reducer<STATE>, newState: STATE) {
        // NoOp
    }
}
