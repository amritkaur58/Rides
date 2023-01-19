package com.amrit.rides.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.amrit.rides.data.datasource.remote.RetrofitClient
import com.amrit.rides.data.datasource.remote.VehicleListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object VehicleListRepository {

    val serviceData = MutableLiveData<List<VehicleListResponse>?>()


    fun getServiceApiCall(countValue: Int): MutableLiveData<List<VehicleListResponse>?> {

        val call = RetrofitClient.apiInterface.getVehicleList(countValue)
        call.enqueue(object : Callback<List<VehicleListResponse>> {
            override fun onResponse(
                call: Call<List<VehicleListResponse>>,
                response: Response<List<VehicleListResponse>>
            ) {

                val data = response.body()
                serviceData.postValue(data)
            }

            override fun onFailure(call: Call<List<VehicleListResponse>>, t: Throwable) {
                Log.e("DEBUG", t.message.toString())
            }

        })

        return serviceData
    }

}