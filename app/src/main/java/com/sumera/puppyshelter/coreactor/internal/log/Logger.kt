package com.sumera.puppyshelter.coreactor.internal.log

import com.sumera.puppyshelter.coreactor.internal.log.impl.ConsoleLogger

object Logger {

    interface Writer {
        fun logMessage(tag: String, message: String)
    }

    var writer: Writer = ConsoleLogger()

    fun log(tag: String, message: String) {
        writer.logMessage(tag, message)
    }
}
