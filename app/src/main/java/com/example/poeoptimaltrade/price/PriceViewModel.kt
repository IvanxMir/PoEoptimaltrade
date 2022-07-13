package com.example.poeoptimaltrade.price

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.poeoptimaltrade.database.PoeTradeDatabase
import com.example.poeoptimaltrade.database.entity.*
import com.example.poeoptimaltrade.repository.PoeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class PriceViewModel(private val categoryId: Int, val database: PoeTradeDatabase, application: Application): ViewModel() {
    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)
    val viewModelScopeIo = CoroutineScope(viewModelJob + Dispatchers.IO)
    //private val poeRepository = PoeRepository(database)
    var data = emptyList<Any>()

    private val _categoryData = when(categoryId) {
        1 -> database.currencyDao.getAllCurrencys()
        2 -> database.fragmentDao.getAllFragment()
        3 -> database.divinationCardDao.getAllDivinationCards()
        4 -> database.scarabDao.getAllScarabs()
        5 -> database.fossilDao.getAllFossils()
        6 -> database.deliriumOrbDao.getAllDeliriumOrbs()
        7 -> database.oilDao.getAllOils()
        8 -> database.sentinelDao.getAllSentinels()
        9 -> database.beastDao.getAllBeasts()
        10 -> database.artifactDao.getAllArtifacts()
        11 -> database.resonatorDao.getAllResonators()
        else -> database.vialDao.getAllVials()
    }
    val categoryData
        get() = _categoryData

    init {
        viewModelScope.launch {
            //poeRepository.refreshPoeDataTrade()
        }
    }

    fun getData() = viewModelScopeIo.launch {data = getSortData()}

    fun getSortData(): List<Any> {
        return when (categoryId) {
            1 -> {
                database.currencyDao.getAllСommonCurrencys()
                    .sortedBy { it.standardPrice!! / it.leaguePrice!! }.asReversed()
            }
            2 -> {
                database.fragmentDao.getAllCommonFragment()
                    .sortedBy { it.standardPrice!! / it.leaguePrice!! }.asReversed()
            }
            3 -> {
                database.divinationCardDao.getAllCommonDivinationCards()
                    .sortedBy { it.standardPrice!! / it.leaguePrice!! }.asReversed()
            }
            4 -> {
                database.scarabDao.getAllCommonScarabs()
                    .sortedBy { it.standardPrice!! / it.leaguePrice!! }.asReversed()
            }
            5 -> {
                database.fossilDao.getAllCommonFossils()
                    .sortedBy { it.standardPrice!! / it.leaguePrice!! }.asReversed()
            }
            6 -> {
                database.deliriumOrbDao.getAllCommonDeliriumOrbs()
                    .sortedBy { it.standardPrice!! / it.leaguePrice!! }.asReversed()
            }
            7 -> {
                database.oilDao.getAllCommonOils()
                    .sortedBy { it.standardPrice!! / it.leaguePrice!! }.asReversed()
            }
            8 -> {
                database.sentinelDao.getAllCommonSentinels()
                    .sortedBy { it.standardPrice!! / it.leaguePrice!! }.asReversed()
            }
            9 -> {
                database.beastDao.getAllCommonBeasts()
                    .sortedBy { it.standardPrice!! / it.leaguePrice!! }.asReversed()
            }
            10 -> {
                database.artifactDao.getAllCommonArtifacts()
                    .sortedBy { it.standardPrice!! / it.leaguePrice!! }.asReversed()
            }
            11 -> {
                database.resonatorDao.getAllCommonResonators()
                    .sortedBy { it.standardPrice!! / it.leaguePrice!! }.asReversed()
            }
            12 -> {
                database.vialDao.getAllCommonVials()
                    .sortedBy { it.standardPrice!! / it.leaguePrice!! }.asReversed()
            }
            else -> emptyList()
        }
    }

    fun getSearchData(data: List<Any>, searchText: String): List<Any> {
        var searchData = data
        val patternRegex = searchText.toRegex(RegexOption.IGNORE_CASE)

        when (categoryId) {
            1 -> {
                searchData = searchData as List<Currency>
                searchData = searchData.filter {  patternRegex.containsMatchIn(it.name.toString()) }
            }
            2 -> {
                searchData = searchData as List<com.example.poeoptimaltrade.database.entity.Fragment>
                searchData = searchData.filter {  patternRegex.containsMatchIn(it.name.toString()) }
            }
            3 -> {
                searchData = searchData as List<DivinationCard>
                searchData = searchData.filter {  patternRegex.containsMatchIn(it.name.toString()) }
            }
            4 -> {
                searchData = searchData as List<Scarab>
                searchData = searchData.filter {  patternRegex.containsMatchIn(it.name.toString()) }
            }
            5 -> {
                searchData = searchData as List<Fossil>
                searchData = searchData.filter {  patternRegex.containsMatchIn(it.name.toString()) }
            }
            6 -> {
                searchData = searchData as List<DeliriumOrb>
                searchData = searchData.filter {  patternRegex.containsMatchIn(it.name.toString()) }
            }
            7 -> {
                searchData = searchData as List<Oil>
                searchData = searchData.filter {  patternRegex.containsMatchIn(it.name.toString()) }
            }
            8 -> {
                searchData = searchData as List<Sentinel>
                searchData = searchData.filter {  patternRegex.containsMatchIn(it.name.toString()) }
            }
            9 -> {
                searchData = searchData as List<Beast>
                searchData = searchData.filter {  patternRegex.containsMatchIn(it.name.toString()) }
            }
            10 -> {
                searchData = searchData as List<Artifact>
                searchData = searchData.filter {  patternRegex.containsMatchIn(it.name.toString()) }
            }
            11 -> {
                searchData = searchData as List<Resonator>
                searchData = searchData.filter {  patternRegex.containsMatchIn(it.name.toString()) }
            }
            12 -> {
                searchData = searchData as List<Vial>
                searchData = searchData.filter {  patternRegex.containsMatchIn(it.name.toString()) }
            }
        }
        return searchData
    }
}