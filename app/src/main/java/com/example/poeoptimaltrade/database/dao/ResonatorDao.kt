package com.example.poeoptimaltrade.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.poeoptimaltrade.database.entity.Resonator

@Dao
interface ResonatorDao {
    @Insert
    fun resonatorInsert(resonator: Resonator)

    @Update
    fun resonatorUpdate(resonator: Resonator)

    @Delete
    fun resonatorDelete(resonator: Resonator)

    @Query("DELETE FROM resonator_table" )
    fun deleteAllResonators()

    @Query("SELECT * FROM resonator_table WHERE id = :id")
    fun getResonator(id: Int): Resonator

    @Query("UPDATE resonator_table SET resonator_league_price = :leaguePrice WHERE resonator_name = :name")
    fun setResonatorLeagueData(name: String, leaguePrice: Float)

    @Query("UPDATE resonator_table SET resonator_standard_price = :standardPrice WHERE resonator_name = :name")
    fun setResonatorStandardData(name: String, standardPrice: Float)

    @Query("SELECT * FROM resonator_table")
    fun getAllResonators(): LiveData<List<Resonator>>

    @Query("SELECT * FROM resonator_table")
    fun getAllCommonResonators(): List<Resonator>
}