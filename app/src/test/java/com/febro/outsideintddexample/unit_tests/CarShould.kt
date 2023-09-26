package com.febro.outsideintddexample.unit_tests
import com.febro.outsideintddexample.Car
import com.febro.outsideintddexample.Engine
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.*

// 'Should' name convention comes from TDD practitioner called Sandro Mancuso
class CarShould {
    private val engine = mock(Engine::class.java)
    private val car = Car(engine, 5.0)

    @Test
    fun looseFuelWhenItTurnsOn() {
        car.turnOn()

        assertEquals(4.5, car.fuel)
    }

    @Test
    fun turnOnItsEngine() {
        car.turnOn()

        // times: number of the times the method will be executed
        verify(engine, times(1)).turnOn()
    }

}