package com.amrit.rides.presentation.ui.fragments

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.amrit.rides.R
import com.amrit.rides.databinding.FragmentSplashBinding
import com.amrit.rides.presentation.base.BaseFragment
import com.amrit.rides.viewmodels.AppViewModel
import java.util.*
import kotlin.concurrent.schedule

class SplashFragment : BaseFragment<FragmentSplashBinding, AppViewModel>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun navigateToVehicleList() {
        findNavController().navigate(R.id.vehicleList)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_splash
    }

    override fun getViewModel(): Class<AppViewModel> {
        return AppViewModel::class.java
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Timer("SettingUp",false).schedule(2000)
        {
            navigateToVehicleList()
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

}
