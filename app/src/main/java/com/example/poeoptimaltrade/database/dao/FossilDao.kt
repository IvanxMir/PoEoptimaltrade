package com.example.poeoptimaltrade.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.poeoptimaltrade.database.entity.Fossil

@Dao
interface FossilDao {
    @Insert
    fun fossilInsert(fossil: Fossil)

    @Update
    fun fossilUpdate(fossil: Fossil)

    @Delete
    fun fossilDelete(fossil: Fossil)

    @Query("DELETE FROM fossil_table" )
    fun deleteAllFossils()

    @Query("SELECT * FROM fossil_table WHERE id = :id")
    fun getFossil(id: Int): Fossil

    @Query("UPDATE fossil_table SET fossil_league_price = :leaguePrice WHERE fossil_name = :name")
    fun setFossilLeagueData(name: String, leaguePrice: Float)

    @Query("UPDATE fossil_table SET fossil_standard_price = :standardPrice WHERE fossil_name = :name")
    fun setFossilStandardData(name: String, standardPrice: Float)

    @Query("SELECT * FROM fossil_table")
    fun getAllFossils(): LiveData<List<Fossil>>

    @Query("SELECT * FROM fossil_table")
    fun getAllCommonFossils(): List<Fossil>
}