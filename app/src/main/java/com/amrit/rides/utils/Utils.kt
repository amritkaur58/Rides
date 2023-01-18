package com.amrit.rides.utils

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.amrit.rides.R

class Utils {

    companion object {
        @JvmStatic
        fun navigateUsingPopUp(navController: NavController, popUpFragId: Int, destinationId: Int) {
            var navOptions = NavOptions.Builder()
                .setEnterAnim(R.anim.slide_in_right)
                .setExitAnim(R.anim.slide_out_left)
                .setPopEnterAnim(R.anim.slide_in_left)
                .setPopExitAnim(R.anim.slide_out_right)
                .setPopUpTo(popUpFragId, true)
                .build()

        }
    }
}