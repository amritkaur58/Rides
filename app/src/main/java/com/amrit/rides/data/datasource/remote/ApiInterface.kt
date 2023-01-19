package com.amrit.rides.data.datasource.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {

    @GET("vehicle/random_vehicle")
    fun getVehicleList(@Query("size") size: Int): Call<List<VehicleListResponse>>

}
