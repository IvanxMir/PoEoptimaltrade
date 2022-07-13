package com.example.poeoptimaltrade.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.poeoptimaltrade.database.entity.Vial

@Dao
interface VialDao {
    @Insert
    fun vialInsert(vial: Vial)

    @Update
    fun vialUpdate(vial: Vial)

    @Delete
    fun vialDelete(vial: Vial)

    @Query("DELETE FROM vial_table" )
    fun deleteAllVials()

    @Query("SELECT * FROM vial_table WHERE id = :id")
    fun getVial(id: Int): Vial

    @Query("UPDATE vial_table SET vial_league_price = :leaguePrice WHERE vial_name = :name")
    fun setVialLeagueData(name: String, leaguePrice: Float)

    @Query("UPDATE vial_table SET vial_standard_price = :standardPrice WHERE vial_name = :name")
    fun setVialStandardData(name: String, standardPrice: Float)

    @Query("SELECT * FROM vial_table")
    fun getAllVials(): LiveData<List<Vial>>

    @Query("SELECT * FROM vial_table")
    fun getAllCommonVials(): List<Vial>
}