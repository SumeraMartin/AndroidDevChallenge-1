package com.sumera.puppyshelter.data.base

sealed class Result<out DATA> {

    data class Success<DATA>(val data: DATA) : Result<DATA>()

    data class Error(val error: Throwable) : Result<Nothing>()
}

suspend fun <DATA> wrapResult(block: suspend () -> DATA): Result<DATA> {
    val result = runCatching { block() }

    val data = result.getOrNull()
    if (data != null) {
        return Result.Success(data)
    }

    val error = result.exceptionOrNull()
    if (error != null) {
        return Result.Error(error)
    }

    error("Unexpected state: $result")
}