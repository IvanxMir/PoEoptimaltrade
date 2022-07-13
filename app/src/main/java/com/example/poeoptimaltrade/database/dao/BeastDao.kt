package com.example.poeoptimaltrade.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.poeoptimaltrade.database.entity.Artifact
import com.example.poeoptimaltrade.database.entity.Beast

@Dao
interface BeastDao {
    @Insert
    fun beastInsert(beast: Beast)

    @Update
    fun beastUpdate(beast: Beast)

    @Delete
    fun beastDelete(beast: Beast)

    @Query("DELETE FROM beast_table" )
    fun deleteAllBeasts()

    @Query("SELECT * FROM beast_table WHERE id = :id")
    fun getBeast(id: Int): Beast

    @Query("UPDATE beast_table SET beast_league_price = :leaguePrice WHERE beast_name = :name")
    fun setBeastLeagueData(name: String, leaguePrice: Float)

    @Query("UPDATE beast_table SET beast_standard_price = :standardPrice WHERE beast_name = :name")
    fun setBeastStandardData(name: String, standardPrice: Float)

    @Query("SELECT * FROM beast_table")
    fun getAllBeasts(): LiveData<List<Beast>>

    @Query("SELECT * FROM beast_table")
    fun getAllCommonBeasts(): List<Beast>
}