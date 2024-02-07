package com.example.mystartjetpack.db

import androidx.room.*
import com.example.mystartjetpack.data.User


@Database(
    entities = [User::class],
    version = 1,
    exportSchema = true
)
abstract class DataDatabase : RoomDatabase() {
    abstract fun getDataDao(): DataDao
}