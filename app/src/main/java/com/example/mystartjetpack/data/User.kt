package com.example.mystartjetpack.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userTable")
data class User(var name: String, var password: String) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
