package com.febro.outsideintddexample.acceptance_tests

import com.febro.outsideintddexample.Car
import com.febro.outsideintddexample.Engine
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Test

class CarFeature {
    private val engine = Engine()
    private val car = Car(engine, 6.0)
    // naming is long for describing the full functionality of the feature

    @Test
    fun carIsLoosingFuelWhenItTurnsOn() {
        car.turnOn()

        assertEquals(5.5, car.fuel)
    }

    @Test
    fun carIsTurningOnItsEngineAndIncreasesTheTemperature(){
        car.turnOn()

        assertEquals(95, car.engine.temperature)
        assertTrue(car.engine.isTurnedOn)
    }

}