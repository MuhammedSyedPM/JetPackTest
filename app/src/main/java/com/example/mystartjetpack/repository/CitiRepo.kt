package com.example.mystartjetpack.repository
import com.example.mystartjetpack.api.MsApi
import com.example.mystartjetpack.common.Resource
import com.example.mystartjetpack.data.Data
import com.example.mystartjetpack.data.User
import com.example.mystartjetpack.db.DataDao
import javax.inject.Inject

class CityRepository @Inject constructor(private val api: MsApi?,
                                         private val dataDao: DataDao?
) {
    suspend fun getCityList(): Resource<List<Data>> {
        return try {
            val result = api?.getCityDetails("00")
            result?.let {
                if (it.isSuccessful) {
                    val response = it.body()
                    if (response?.status == true) {
                        Resource.Success(data = response.dataSet.data)
                    } else {
                        Resource.Error(message = response?.errorDescription ?: "Unknown error")
                    }
                } else {
                    Resource.Error(message = "Response not successful: ${it.code()}")
                }
            } ?: Resource.Error(message = "Response is null")
        } catch (e: Exception) {
            Resource.Error(message = e.message ?: "Unknown error")
        }
    }

    suspend fun insertData(registerData: MutableList<User>) {
       dataDao?.insertUserData(registerData)
    }
}
