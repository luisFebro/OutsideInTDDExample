package com.febro.outsideintddexample.unit_tests

import com.febro.outsideintddexample.Engine
import com.febro.outsideintddexample.utils.MainCoroutineScopeRule
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test

class EngineShould {
    private val engine = Engine( )

    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @Test
    fun turnOn(): Unit = runBlockingTest {
        engine.turnOn()

        assertTrue(engine.isTurnedOn)
    }

    @Test
    fun riseTheTemperatureWhenItTurnsOn(): Unit = runBlockingTest {
        engine.turnOn()

        assertEquals(95, engine.temperature)

    }

}