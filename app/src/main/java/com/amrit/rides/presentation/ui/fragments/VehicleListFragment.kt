package com.amrit.rides.presentation.ui.fragments

import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.amrit.rides.R
import com.amrit.rides.databinding.FragmentVehicleListBinding
import com.amrit.rides.presentation.base.BaseFragment
import com.amrit.rides.presentation.ui.adapters.VehicleAdapter
import com.amrit.rides.utils.Utils.Companion.hideKeyboard
import com.amrit.rides.utils.Utils.Companion.showToast
import com.amrit.rides.viewmodels.AppViewModel
import kotlinx.android.synthetic.main.fragment_vehicle_list.*


class VehicleListFragment : BaseFragment<FragmentVehicleListBinding, AppViewModel>() {
    private lateinit var adapter: VehicleAdapter

    override fun getLayoutId(): Int {
        return R.layout.fragment_vehicle_list
    }

    override fun getViewModel(): Class<AppViewModel> {
        return AppViewModel::class.java
    }


    override fun onResume() {
        super.onResume()
        getVehicleList()
    }

    private fun getVehicleList() {
        listBT.setOnClickListener {

            if (countET.text?.isEmpty() == true) {
                showToast("Please enter count number", activity)
            } else {
                pBar.visibility = View.VISIBLE
                viewModel.getVehicleList(countET.text.toString().toInt())
                    .observe(this, Observer { vehicleList ->
                        try {
                            activity?.let { it1 -> hideKeyboard(countET, it1) }
                            vehicleList?.sortedBy { it.vin }
                            pBar.visibility = View.GONE
                            adapter = vehicleList?.let { VehicleAdapter(it, navController) }!!
                            listRV.layoutManager = LinearLayoutManager(context)
                            listRV.adapter = adapter

                        } catch (e: java.lang.Exception) {
                            e.printStackTrace()
                        }

                    })

            }

        }

    }
}