package com.example.mystartjetpack

import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun showToast(message: String, context: Context) {
    GlobalScope.launch(Dispatchers.Main) {
        Toast.makeText(context, "$message", Toast.LENGTH_SHORT).show()
    }
}