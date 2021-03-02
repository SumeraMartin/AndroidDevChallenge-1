package com.sumera.puppyshelter.coreactor.internal.log.impl

import android.util.Log
import com.sumera.puppyshelter.coreactor.internal.log.Logger

class ConsoleLogger : Logger.Writer {
    override fun logMessage(tag: String, message: String) {
        Log.d(tag, message)
    }
}