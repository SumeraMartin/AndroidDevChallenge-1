package com.sumera.puppyshelter.tools.extensions

import java.io.IOException

val Throwable.isConnectionError get() = this is IOException
