package com.mobwaysolutions.appdi

import java.util.*

fun main() {

    val instance = Calendar.getInstance()
    instance.set(2023,6, 10)
    println(instance.time.time)

}