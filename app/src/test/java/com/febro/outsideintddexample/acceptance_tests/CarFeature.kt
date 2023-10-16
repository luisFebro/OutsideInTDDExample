package com.febro.outsideintddexample.acceptance_tests

import com.febro.outsideintddexample.Car
import com.febro.outsideintddexample.Engine
import com.febro.outsideintddexample.utils.MainCoroutineScopeRule
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test

class CarFeature {
    private val engine = Engine()
    private val car = Car(engine, 6.0)
    // naming is long for describing the full functionality of the feature

    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @Test
    fun carIsLoosingFuelWhenItTurnsOn(): Unit = runBlockingTest {
        car.turnOn()

        assertEquals(5.5, car.fuel)
    }

    @Test
    fun carIsTurningOnItsEngineAndIncreasesTheTemperature(): Unit = runBlockingTest{
        car.turnOn()

        coroutinesTestRule.advanceTimeBy(6001)
        assertEquals(95, car.engine.temperature)
        assertTrue(car.engine.isTurnedOn)
    }

}