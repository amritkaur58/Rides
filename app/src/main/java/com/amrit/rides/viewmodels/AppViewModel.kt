package com.amrit.rides.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amrit.rides.data.datasource.remote.VehicleListResponse
import com.amrit.rides.data.repository.VehicleListRepository

class AppViewModel : ViewModel() {

    var serviceData = MutableLiveData<List<VehicleListResponse>?>()

    fun getVehicleList(countValue:Int): LiveData<List<VehicleListResponse>?> {

        serviceData = VehicleListRepository.getServiceApiCall(countValue)
        return serviceData
    }

}