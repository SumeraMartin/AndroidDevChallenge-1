package com.sumera.puppyshelter.domain.base

import com.sumera.puppyshelter.data.base.wrapResult
import com.sumera.puppyshelter.data.base.Result

abstract class UseCase<ARGS, RESULT_DATA> {

    protected abstract suspend fun create(args: ARGS): RESULT_DATA

    suspend fun execute(args: ARGS): Result<RESULT_DATA> {
        return wrapResult { create(args) }
    }
}
