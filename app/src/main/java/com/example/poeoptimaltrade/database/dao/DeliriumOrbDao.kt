package com.example.poeoptimaltrade.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.poeoptimaltrade.database.entity.DeliriumOrb

@Dao
interface DeliriumOrbDao {
    @Insert
    fun deliriumOrbInsert(deliriumOrb: DeliriumOrb)

    @Update
    fun deliriumOrbUpdate(deliriumOrb: DeliriumOrb)

    @Delete
    fun deliriumOrbDelete(deliriumOrb: DeliriumOrb)

    @Query("DELETE FROM deliriumOrb_table" )
    fun deleteAllDeliriumOrbs()

    @Query("SELECT * FROM deliriumOrb_table WHERE id = :id")
    fun getDeliriumOrb(id: Int): DeliriumOrb

    @Query("UPDATE deliriumOrb_table SET deliriumOrb_league_price = :leaguePrice WHERE deliriumOrb_name = :name")
    fun setDeliriumOrbLeagueData(name: String, leaguePrice: Float)

    @Query("UPDATE deliriumOrb_table SET deliriumOrb_standard_price = :standardPrice WHERE deliriumOrb_name = :name")
    fun setDeliriumOrbStandardData(name: String, standardPrice: Float)

    @Query("SELECT * FROM deliriumOrb_table")
    fun getAllDeliriumOrbs(): LiveData<List<DeliriumOrb>>

    @Query("SELECT * FROM deliriumOrb_table")
    fun getAllCommonDeliriumOrbs(): List<DeliriumOrb>
}