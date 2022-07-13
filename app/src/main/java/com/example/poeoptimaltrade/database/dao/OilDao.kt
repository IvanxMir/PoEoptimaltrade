package com.example.poeoptimaltrade.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.poeoptimaltrade.database.entity.Oil

@Dao
interface OilDao {
    @Insert
    fun oilInsert(oil: Oil)

    @Update
    fun oilUpdate(oil: Oil)

    @Delete
    fun oilDelete(oil: Oil)

    @Query("DELETE FROM oil_table" )
    fun deleteAllOils()

    @Query("SELECT * FROM oil_table WHERE id = :id")
    fun getOil(id: Int): Oil

    @Query("UPDATE oil_table SET oil_league_price = :leaguePrice WHERE oil_name = :name")
    fun setOilLeagueData(name: String, leaguePrice: Float)

    @Query("UPDATE oil_table SET oil_standard_price = :standardPrice WHERE oil_name = :name")
    fun setOilStandardData(name: String, standardPrice: Float)

    @Query("SELECT * FROM oil_table")
    fun getAllOils(): LiveData<List<Oil>>

    @Query("SELECT * FROM oil_table")
    fun getAllCommonOils(): List<Oil>
}