package com.amrit.rides.presentation.ui.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.amrit.rides.R
import com.amrit.rides.data.datasource.remote.VehicleListResponse
import com.amrit.rides.utils.Utils

class VehicleAdapter(
    private val mList: List<VehicleListResponse>,
    private val navController: NavController
) :
    RecyclerView.Adapter<VehicleAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.vehicle_list_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemViewModel = mList[position]
        holder.modelTV.text = itemViewModel.makeAndModel
        holder.vinTV.text = itemViewModel.vin
        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(Utils.VIN, itemViewModel.vin)
            bundle.putString(Utils.MAKE_MODEL, itemViewModel.makeAndModel)
            bundle.putString(Utils.COLOR, itemViewModel.color)
            bundle.putString(Utils.CAR_TYPE, itemViewModel.carType)
            Utils.navigateUsingPopUp(navController, R.id.vehicleList, R.id.vehicleDetail, bundle)

        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        val modelTV: TextView = itemView.findViewById(R.id.modelTV)
        val vinTV: TextView = itemView.findViewById(R.id.vinTV)

    }
}