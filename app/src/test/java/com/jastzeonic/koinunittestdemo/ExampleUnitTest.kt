package com.jastzeonic.koinunittestdemo

import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.inject
import org.koin.test.KoinTestRule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest : KoinTest {
    private val mockModule = module {
        single<ComponentInterface> { ComponentC() }
    }

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        printLogger()
        modules(appModule, mockModule)
    }

    private val componentA: ComponentA by inject()
    private val componentD: ComponentD by inject()

    @Test
    fun `test the injection`() {
        assertEquals("ComponentC", componentA.getContent())
        assertEquals("ComponentB", componentD.getContent())

    }
}