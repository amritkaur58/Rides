package com.amrit.rides.presentation.ui.fragments

import com.amrit.rides.R
import com.amrit.rides.databinding.FragmentVehicleListBinding
import com.amrit.rides.presentation.base.BaseFragment
import com.amrit.rides.viewmodels.AppViewModel


class VehicleListFragment : BaseFragment<FragmentVehicleListBinding, AppViewModel>() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_vehicle_list
    }

    override fun getViewModel(): Class<AppViewModel> {
        return AppViewModel::class.java
    }


}