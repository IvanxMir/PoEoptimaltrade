package com.example.poeoptimaltrade.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.poeoptimaltrade.database.entity.Scarab

@Dao
interface ScarabDao {
    @Insert
    fun scarabInsert(scarab: Scarab)

    @Update
    fun scarabUpdate(scarab: Scarab)

    @Delete
    fun scarabDelete(scarab: Scarab)

    @Query("DELETE FROM scarab_table" )
    fun deleteAllScarabs()

    @Query("SELECT * FROM scarab_table WHERE id = :id")
    fun getScarab(id: Int): Scarab

    @Query("UPDATE scarab_table SET scarab_league_price = :leaguePrice WHERE scarab_name = :name")
    fun setScarabLeagueData(name: String, leaguePrice: Float)

    @Query("UPDATE scarab_table SET scarab_standard_price = :standardPrice WHERE scarab_name = :name")
    fun setScarabStandardData(name: String, standardPrice: Float)

    @Query("SELECT * FROM scarab_table")
    fun getAllScarabs(): LiveData<List<Scarab>>

    @Query("SELECT * FROM scarab_table")
    fun getAllCommonScarabs(): List<Scarab>
}