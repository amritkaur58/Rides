package com.amrit.rides.presentation.ui.fragments

import androidx.appcompat.app.AppCompatActivity
import com.amrit.rides.R
import com.amrit.rides.databinding.LayoutVehicleDetailBinding
import com.amrit.rides.presentation.base.BaseFragment
import com.amrit.rides.presentation.ui.adapters.VehicleAdapter
import com.amrit.rides.utils.Utils
import com.amrit.rides.utils.Utils.Companion.calculateEmission
import com.amrit.rides.viewmodels.AppViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.layout_bottom_sheet.view.*
import kotlinx.android.synthetic.main.layout_vehicle_detail.*


class VehicleDetailFragment : BaseFragment<LayoutVehicleDetailBinding, AppViewModel>() {
    private var distanceValue: Int = 0
    private lateinit var adapter: VehicleAdapter

    override fun getLayoutId(): Int {
        setThemeName()
        return R.layout.layout_vehicle_detail
    }

    private fun setThemeName() {
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayShowTitleEnabled(true)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Vehicle List"
    }

    override fun getViewModel(): Class<AppViewModel> {
        return AppViewModel::class.java
    }


    override fun onResume() {
        super.onResume()
        setBundleData()

    }

    private fun setButtonListener() {
        clickBT.setOnClickListener {
            val dialog = BottomSheetDialog(requireActivity())
            val view = layoutInflater.inflate(R.layout.layout_bottom_sheet, null)
            var calValue = calculateEmission(distanceValue.toDouble())
            view.valueTV.text = calValue.toString()
            view.idBtnDismiss.setOnClickListener {
                dialog.dismiss()
            }
            dialog.setCancelable(false)
            dialog.setContentView(view)
            dialog.show()
        }
    }

    private fun setBundleData() {
        arguments?.getString(Utils.VIN)?.let {
            vinValue.text = it
        }
        arguments?.getString(Utils.MAKE_MODEL)?.let {
            makeValue.text = it
        }
        arguments?.getString(Utils.COLOR)?.let {
            colorValue.text = it
        }
        arguments?.getString(Utils.CAR_TYPE)?.let {
            typeValue.text = it
        }
        arguments?.getInt(Utils.KILO_METERS)?.let {
            distanceValue = it
        }

        setButtonListener()
    }



}