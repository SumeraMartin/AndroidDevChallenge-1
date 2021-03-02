package com.sumera.puppyshelter.coreactor.internal.assert

import android.os.Looper
import com.sumera.puppyshelter.coreactor.error.CoreactorException

internal object CoreactorMainThreadChecker {

    var ignoreCheck = false

    fun requireMainThread(methodName: String) {
        if (ignoreCheck) {
            return
        }
        if (Looper.getMainLooper().thread != Thread.currentThread()) {
            throw CoreactorException("$methodName method is not called on the main thread")
        }
    }
}

fun requireMainThread(methodName: String) {
    CoreactorMainThreadChecker.requireMainThread(methodName)
}
