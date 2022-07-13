package com.example.poeoptimaltrade.price

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.poeoptimaltrade.database.PoeTradeDatabase
import java.lang.IllegalArgumentException

class PriceViewModelFactory(
    private val categoryId: Int,
    private val database: PoeTradeDatabase,
    private val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PriceViewModel::class.java)) {
            return PriceViewModel(categoryId, database, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}