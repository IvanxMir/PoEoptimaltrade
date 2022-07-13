package com.example.poeoptimaltrade.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.poeoptimaltrade.database.entity.Currency

@Dao
interface CurrencyDao {
    @Insert
    fun currencyInsert(currency: Currency)

    @Update
    fun currencyUpdate(currency: Currency)

    @Delete
    fun currencyDelete(currency: Currency)

    @Query("DELETE FROM currency_table" )
    fun deleteAllCurrencys()

    @Query("SELECT * FROM currency_table WHERE currencyId = :id")
    fun getCurrency(id: Int): Currency

    @Query("UPDATE currency_table SET currency_league_price = :leaguePrice WHERE currency_name = :name")
    fun setCurrencyLeagueData(name: String, leaguePrice: Float)

    @Query("UPDATE currency_table SET currency_standard_price = :standardPrice WHERE currency_name = :name")
    fun setCurrencyStandardData(name: String, standardPrice: Float)

    @Query("SELECT * FROM currency_table")
    fun getAllCurrencys(): LiveData<List<Currency>>

    @Query("SELECT * FROM currency_table")
    fun getAllСommonCurrencys(): List<Currency>
}