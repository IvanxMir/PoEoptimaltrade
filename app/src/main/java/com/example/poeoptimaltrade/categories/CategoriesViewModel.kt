package com.example.poeoptimaltrade.categories

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.poeoptimaltrade.database.PoeTradeDatabase
import com.example.poeoptimaltrade.repository.PoeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.util.*

class CategoriesViewModel(val database: PoeTradeDatabase, application: Application) : ViewModel() {
    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)
    private val poeRepository = PoeRepository(database)
    val categories = database.categoryDao.getAllCategories()

    private val _navigateToPrice = MutableLiveData<Int?>()
    val navigateToPrice
        get() = _navigateToPrice

    init {
        if(isOnline(application.baseContext)) {
            Timer().schedule(object : TimerTask() {
                override fun run() {
                    viewModelScope.launch {
                        poeRepository.refreshPoeDataTrade()
                    }
                }
            }, 10, 120000)
        }
    }

    private fun isOnline(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return if (netInfo != null && netInfo.isConnectedOrConnecting) true else false
    }

    fun onCategoryClicked(id: Int){
        _navigateToPrice.value = id
    }

    fun onPriceNavigated() {
        _navigateToPrice.value = null
    }
}