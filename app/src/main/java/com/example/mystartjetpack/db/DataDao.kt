package com.example.mystartjetpack.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mystartjetpack.data.User
import kotlinx.coroutines.flow.Flow


@Dao
interface DataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserData(data: List<User>)

    @Query("Select * from userTable")
    fun getUsers() : Flow<List<User>>




}