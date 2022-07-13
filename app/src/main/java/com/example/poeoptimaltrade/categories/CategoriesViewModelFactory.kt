package com.example.poeoptimaltrade.categories

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.poeoptimaltrade.database.PoeTradeDatabase
import java.lang.IllegalArgumentException

class CategoriesViewModelFactory(
    private val database: PoeTradeDatabase,
    private val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CategoriesViewModel::class.java)) {
            return CategoriesViewModel(database, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}