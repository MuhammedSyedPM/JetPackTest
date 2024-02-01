package com.example.mystartjetpack.repository
import com.example.mystartjetpack.api.MsApi
import com.example.mystartjetpack.common.Resource
import com.example.mystartjetpack.data.Data
import javax.inject.Inject

 class CityRepository @Inject constructor (private val api: MsApi?) {
     suspend fun getCityList(): Resource<List<Data>> {
         return try {
             val result = api?.getCityDetails("00")
             result?.let {
                 if (it.isSuccessful) {
                     it.body()?.let { response ->
                         if (response.status) {
                             Resource.Success(data = response.dataSet.data)
                         } else {
                             Resource.Error(message = response.errorDescription ?: "Unknown error")
                         }
                     } ?: Resource.Error(message = "Response body is null")
                 } else {
                     Resource.Error(message = "Response not successful: ${it.code()}")
                 }
             } ?: Resource.Error(message = "Response is null")
         } catch (e: Exception) {
             Resource.Error(message = e.message ?: "Unknown error")
         }
     }

 }
