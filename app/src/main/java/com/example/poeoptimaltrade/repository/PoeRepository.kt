package com.example.poeoptimaltrade.repository

import com.example.poeoptimaltrade.database.PoeTradeDatabase
import com.example.poeoptimaltrade.network.PoeApi
import com.example.poeoptimaltrade.network.PoeOrdinaryResponseData
import com.example.poeoptimaltrade.network.PoeRestResponseData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private const val LEAGUE = "Sentinel"
private const val STANDARD = "Standard"

class PoeRepository(private val database: PoeTradeDatabase) {
    val category: List<String> = listOf("Currency", "Fragment")
    val restCategory: List<String> = listOf("DivinationCard", "Scarab", "Vial", "Fossil",
    "DeliriumOrb", "Oil", "Incubator", "Artifact", "Resonator")

    suspend fun refreshPoeDataTrade() {
        withContext(Dispatchers.IO) {
            for (item in category) {
                val leagueData = PoeApi.retrofitService.getData(LEAGUE, item)
                val resultLeagueData = leagueData.await()
                val standardData = PoeApi.retrofitService.getData(STANDARD, item)
                val resultStandardData = standardData.await()

                updateDatabaseData(resultLeagueData, resultStandardData, item)
            }
            for (item in restCategory) {
                val leagueRestData = PoeApi.retrofitService.getRestData(LEAGUE, item)
                val resultLeagueRestData = leagueRestData.await()
                val standardRestData = PoeApi.retrofitService.getRestData(STANDARD, item)
                val resultStandardRestData = standardRestData.await()

                updateRestDatabaseData(resultLeagueRestData, resultStandardRestData, item)
            }
        }
    }

    private fun updateDatabaseData(
        resultLeagueData: PoeOrdinaryResponseData,
        resultStandardData: PoeOrdinaryResponseData,
        category: String
    ) {
        when (category) {
            "Currency" -> {
                for (i in 0 until resultLeagueData.lines.size) {
                    database.currencyDao.setCurrencyLeagueData(
                        resultLeagueData.lines[i].name,
                        resultLeagueData.lines[i].price
                    )
                    database.currencyDao.setCurrencyStandardData(
                        resultStandardData.lines[i].name,
                        resultStandardData.lines[i].price
                    )
                }
            }
            "Fragment" -> {
                for (i in 0 until resultLeagueData.lines.size) {
                    database.fragmentDao.setFragmentLeagueData(
                        resultLeagueData.lines[i].name,
                        resultLeagueData.lines[i].price
                    )
                    database.fragmentDao.setFragmentStandardData(
                        resultStandardData.lines[i].name,
                        resultStandardData.lines[i].price
                    )
                }
            }

        }
    }

    private fun updateRestDatabaseData(
        resultLeagueData: PoeRestResponseData,
        resultStandardData: PoeRestResponseData,
        category: String
    ) {
        when (category) {
            "DivinationCard" -> {
                for (i in 0 until resultLeagueData.lines.size) {
                    database.divinationCardDao.setDivinationCardLeagueData(
                        resultLeagueData.lines[i].name,
                        resultLeagueData.lines[i].price
                    )
                    database.divinationCardDao.setDivinationCardStandardData(
                        resultStandardData.lines[i].name,
                        resultStandardData.lines[i].price
                    )
                }
            }
            "Scarab" -> {
                for (i in 0 until resultLeagueData.lines.size) {
                    database.scarabDao.setScarabLeagueData(
                        resultLeagueData.lines[i].name,
                        resultLeagueData.lines[i].price
                    )
                    database.scarabDao.setScarabStandardData(
                        resultStandardData.lines[i].name,
                        resultStandardData.lines[i].price
                    )
                }
            }
            "Vial" -> {
                for (i in 0 until resultLeagueData.lines.size) {
                    database.vialDao.setVialLeagueData(
                        resultLeagueData.lines[i].name,
                        resultLeagueData.lines[i].price
                    )
                    database.vialDao.setVialStandardData(
                        resultStandardData.lines[i].name,
                        resultStandardData.lines[i].price
                    )
                }
            }
            "Fossil" -> {
                for (i in 0 until resultLeagueData.lines.size) {
                    database.fossilDao.setFossilLeagueData(
                        resultLeagueData.lines[i].name,
                        resultLeagueData.lines[i].price
                    )
                    database.fossilDao.setFossilStandardData(
                        resultStandardData.lines[i].name,
                        resultStandardData.lines[i].price
                    )
                }
            }
            "DeliriumOrb" -> {
                for (i in 0 until resultLeagueData.lines.size) {
                    database.deliriumOrbDao.setDeliriumOrbLeagueData(
                        resultLeagueData.lines[i].name,
                        resultLeagueData.lines[i].price
                    )
                    database.deliriumOrbDao.setDeliriumOrbStandardData(
                        resultStandardData.lines[i].name,
                        resultStandardData.lines[i].price
                    )
                }
            }
            "Oil" -> {
                for (i in 0 until resultLeagueData.lines.size) {
                    database.oilDao.setOilLeagueData(
                        resultLeagueData.lines[i].name,
                        resultLeagueData.lines[i].price
                    )
                    database.oilDao.setOilStandardData(
                        resultStandardData.lines[i].name,
                        resultStandardData.lines[i].price
                    )
                }
            }
            "Incubator" -> {
                for (i in 0 until resultLeagueData.lines.size) {
                    database.sentinelDao.setSentinelLeagueData(
                        resultLeagueData.lines[i].name,
                        resultLeagueData.lines[i].price
                    )
                    database.sentinelDao.setSentinelStandardData(
                        resultStandardData.lines[i].name,
                        resultStandardData.lines[i].price
                    )
                }
            }
            "Artifact" -> {
                for (i in 0 until resultLeagueData.lines.size) {
                    database.artifactDao.setArtifactLeagueData(
                        resultLeagueData.lines[i].name,
                        resultLeagueData.lines[i].price
                    )
                    database.artifactDao.setArtifactStandardData(
                        resultStandardData.lines[i].name,
                        resultStandardData.lines[i].price
                    )
                }
            }
            "Resonator" -> {
                for (i in 0 until resultLeagueData.lines.size) {
                    database.resonatorDao.setResonatorLeagueData(
                        resultLeagueData.lines[i].name,
                        resultLeagueData.lines[i].price
                    )
                    database.resonatorDao.setResonatorStandardData(
                        resultStandardData.lines[i].name,
                        resultStandardData.lines[i].price
                    )
                }
            }
            "Beast" -> {
                for (i in 0 until resultLeagueData.lines.size) {
                    database.beastDao.setBeastLeagueData(
                        resultLeagueData.lines[i].name,
                        resultLeagueData.lines[i].price
                    )
                    database.beastDao.setBeastStandardData(
                        resultStandardData.lines[i].name,
                        resultStandardData.lines[i].price
                    )
                }
            }
        }
    }
}

// Для добавления данных у новых страниц можно использовать следующий кусок кода
// Если заменить insert метод на update то можно обновлять данные в таблице если изменится иконка предмета или его название
/*for (i in 0..resultLeagueRestData.lines.size - 1) {
                    if (resultLeagueRestData.lines[i].price != null && resultStandardRestData.lines[i].price != null) {
                        val oil = DivinationCard(i + 1, resultLeagueRestData.lines[i].name, resultLeagueRestData.lines[i].price, resultStandardRestData.lines[i].price, resultLeagueRestData.lines[i].icon)
                        database.divinationCardDao.divinationCardInsert(oil)
                    }
                }
}*/

//var category: List<String> = listOf("Currency", "Fragment", "DivinationCard", "Scarab", "Vial", "Fossil",
//    "DeliriumOrb", "Oil", "Incubator", "Artifact", "Resonator", "Beast")


//database.fragmentDao.fragmentInsert(fragment)
//var fragment = Fragment(5, "", 0.0f, 0.0f, "")