package com.febro.outsideintddexample.unit_tests
import com.febro.outsideintddexample.Car
import com.febro.outsideintddexample.Engine
import com.febro.outsideintddexample.utils.MainCoroutineScopeRule
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

// 'Should' name convention comes from TDD practitioner called Sandro Mancuso
class CarShould {
    private val engine = mock(Engine::class.java)
    private val car = Car(engine, 5.0)

    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @Test
    fun looseFuelWhenItTurnsOn(): Unit = runBlockingTest {
        car.turnOn()

        assertEquals(4.5, car.fuel)
    }

    @Test
    fun turnOnItsEngine(): Unit = runBlockingTest {
        car.turnOn()

        // times: number of the times the method will be executed
        verify(engine, times(1)).turnOn()
    }

}