package com.sumera.puppyshelter.coreactor.interceptor.impl

import com.sumera.puppyshelter.coreactor.lifecycle.LifecycleState
import com.sumera.puppyshelter.coreactor.action.Action
import com.sumera.puppyshelter.coreactor.reducer.Reducer
import com.sumera.puppyshelter.coreactor.contract.state.State
import com.sumera.puppyshelter.coreactor.interceptor.CoreactorInterceptor

open class SimpleInterceptor<STATE : State, ACTION : Action<STATE>> : CoreactorInterceptor<STATE, ACTION> {

    override fun onInterceptState(state: STATE): STATE? {
        return state
    }

    override fun onInterceptAction(action: ACTION): ACTION? {
        return action
    }

    override fun onInterceptReducer(reducer: Reducer<STATE>): Reducer<STATE>? {
        return reducer
    }

    override fun onLifecycleStateChanged(lifecycleState: LifecycleState) {
        // NoOp
    }
}