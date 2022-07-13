package com.example.poeoptimaltrade.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.poeoptimaltrade.database.entity.Sentinel

@Dao
interface SentinelDao {
    @Insert
    fun sentinelInsert(sentinel: Sentinel)

    @Update
    fun sentinelUpdate(sentinel: Sentinel)

    @Delete
    fun sentinelDelete(sentinel: Sentinel)

    @Query("DELETE FROM sentinel_table" )
    fun deleteAllSentinels()

    @Query("SELECT * FROM sentinel_table WHERE id = :id")
    fun getSentinel(id: Int): Sentinel

    @Query("UPDATE sentinel_table SET sentinel_league_price = :leaguePrice WHERE sentinel_name = :name")
    fun setSentinelLeagueData(name: String, leaguePrice: Float)

    @Query("UPDATE sentinel_table SET sentinel_standard_price = :standardPrice WHERE sentinel_name = :name")
    fun setSentinelStandardData(name: String, standardPrice: Float)

    @Query("SELECT * FROM sentinel_table")
    fun getAllSentinels(): LiveData<List<Sentinel>>

    @Query("SELECT * FROM sentinel_table")
    fun getAllCommonSentinels(): List<Sentinel>
}