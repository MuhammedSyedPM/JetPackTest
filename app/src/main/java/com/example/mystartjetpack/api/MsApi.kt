
package com.example.mystartjetpack.api

import com.example.mystartjetpack.data.CityResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface MsApi {

    @GET("City/GetCity")
    suspend fun getCityDetails(
        @Query("CustID") customerID: String
    ): Response<CityResponse>





}
