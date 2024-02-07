package com.example.mystartjetpack.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_table")
data class Cart(
    var productId: String,
    var categoryId: String,
    var name: String,
    var imgUrl: String,
    var qty: String,
    var barcode:String?=""
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
