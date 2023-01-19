package com.amrit.rides.utils

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.amrit.rides.R

class Utils {

    companion object {
        val CAR_TYPE: String? = "carType"
        val KILO_METERS: String? = "kilometrage"
        val COLOR: String? = "color"
        val MAKE_MODEL: String? = "makeModel"
        val VIN: String? = "VIN"

        fun calculateEmission(distance: Double): Double {

            return if (distance <= 5000) {
                distance * 1
            } else {
                (5000 * 1) + (distance - 5000) * 1.5
            }
        }

        @JvmStatic
        fun navigateUsingPopUp(
            navController: NavController,
            popUpFragId: Int,
            destinationId: Int,
            bundle: Bundle
        ) {
            var navOptions = NavOptions.Builder()
                .setEnterAnim(R.anim.slide_in_right)
                .setExitAnim(R.anim.slide_out_left)
                .setPopEnterAnim(R.anim.slide_in_left)
                .setPopExitAnim(R.anim.slide_out_right)
                .setPopUpTo(popUpFragId, true)
                .build()
            navController.navigate(destinationId, bundle)


        }

        fun showToast(msg: String, context: Context?) {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }

        fun hideKeyboard(view: View, context: Context) {
            val inputMethodManager =
                context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }


}