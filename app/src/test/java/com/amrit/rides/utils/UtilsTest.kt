package com.amrit.rides.utils

import com.amrit.rides.utils.Utils.Companion.calculateEmission
import org.junit.Assert.*

import org.junit.Test

class UtilsTest {

    @Test
    fun calculateTest() {

        val result =  calculateEmission(5000.0)
        val expected  = 5000.0
        assertEquals(expected,result,0.001)
    }
}