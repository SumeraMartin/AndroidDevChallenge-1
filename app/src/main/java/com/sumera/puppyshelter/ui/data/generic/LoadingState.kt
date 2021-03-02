package com.sumera.puppyshelter.ui.data.generic

sealed class LoadingState<out DATA> {

    object Loading : LoadingState<Nothing>()

    data class Error(val error: Throwable) : LoadingState<Nothing>()

    data class Success<DATA>(val data: DATA) : LoadingState<DATA>()
}
