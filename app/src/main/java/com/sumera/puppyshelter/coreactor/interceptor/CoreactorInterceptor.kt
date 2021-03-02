package com.sumera.puppyshelter.coreactor.interceptor

import com.sumera.puppyshelter.coreactor.lifecycle.LifecycleState
import com.sumera.puppyshelter.coreactor.action.Action
import com.sumera.puppyshelter.coreactor.reducer.Reducer
import com.sumera.puppyshelter.coreactor.contract.state.State

interface CoreactorInterceptor<STATE : State, ACTION : Action<STATE>> {

    fun onInterceptState(state: STATE): STATE?

    fun onInterceptAction(action: ACTION): ACTION?

    fun onInterceptReducer(reducer: Reducer<STATE>): Reducer<STATE>?

    fun onLifecycleStateChanged(lifecycleState: LifecycleState)
}
