package com.febro.outsideintddexample

import kotlinx.coroutines.delay

class Engine(
    var temperature: Int = 15,
    var isTurnedOn: Boolean = false
) {

    suspend fun turnOn() {
        isTurnedOn = true
        delay(6000)
        temperature = 95
    }
}