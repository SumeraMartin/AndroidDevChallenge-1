package com.sumera.puppyshelter.tools.debug

import java.io.IOException
import java.lang.IllegalStateException
import kotlin.random.Random

fun randomError() {
    if (Random.nextBoolean()) {
        if (Random.nextBoolean()) {
            throw IOException()
        } else {
            throw IllegalStateException()
        }
    }
}
