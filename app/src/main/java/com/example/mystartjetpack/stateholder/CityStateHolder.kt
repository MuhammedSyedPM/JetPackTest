package com.example.mystartjetpack.stateholder

import com.example.mystartjetpack.data.Data

data class CityStateHolder(
    val isLoading: Boolean = false,
    val datas: List<Data>? = null,
    val error: String = ""
)
