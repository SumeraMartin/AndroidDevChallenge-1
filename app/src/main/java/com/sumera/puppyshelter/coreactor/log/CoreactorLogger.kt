package com.sumera.puppyshelter.coreactor.log

import com.sumera.puppyshelter.coreactor.lifecycle.LifecycleState
import com.sumera.puppyshelter.coreactor.action.Action
import com.sumera.puppyshelter.coreactor.reducer.Reducer
import com.sumera.puppyshelter.coreactor.contract.state.State

interface CoreactorLogger<STATE : State> {

    fun onState(state: STATE)

    fun onStateDispatchedToView(state: STATE)

    fun onAction(action: Action<STATE>)

    fun onLifecycle(lifecycleState: LifecycleState)

    fun onReducer(oldState: STATE, reducer: Reducer<STATE>, newState: STATE)
}
