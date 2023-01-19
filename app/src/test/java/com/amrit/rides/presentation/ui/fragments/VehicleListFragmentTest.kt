package com.amrit.rides.presentation.ui.fragments

import kotlinx.android.synthetic.main.fragment_vehicle_list.*
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


class VehicleListFragmentTest {



    @Test
    fun validateField_expectedRequiredField() {
        val fragment = VehicleListFragment()

       val result =  fragment.checkTextRange("21")
        assertEquals(true,result)

    }
}