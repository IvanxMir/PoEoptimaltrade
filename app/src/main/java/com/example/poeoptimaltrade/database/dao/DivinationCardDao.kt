package com.example.poeoptimaltrade.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.poeoptimaltrade.database.entity.DivinationCard

@Dao
interface DivinationCardDao {
    @Insert
    fun divinationCardInsert(divinationCard: DivinationCard)

    @Update
    fun divinationCardUpdate(divinationCard: DivinationCard)

    @Delete
    fun divinationCardDelete(divinationCard: DivinationCard)

    @Query("DELETE FROM divinationCard_table WHERE id = :id" )
    fun deleteDivinationCardId(id: Int)

    @Query("DELETE FROM divinationCard_table" )
    fun deleteAllDivinationCards()

    @Query("SELECT * FROM divinationCard_table WHERE id = :id")
    fun getDivinationCard(id: Int): DivinationCard

    @Query("UPDATE divinationCard_table SET divinationCard_league_price = :leaguePrice WHERE divinationCard_name = :name")
    fun setDivinationCardLeagueData(name: String, leaguePrice: Float)

    @Query("UPDATE divinationCard_table SET divinationCard_standard_price = :standardPrice WHERE divinationCard_name = :name")
    fun setDivinationCardStandardData(name: String, standardPrice: Float)

    @Query("SELECT * FROM divinationCard_table")
    fun getAllDivinationCards(): LiveData<List<DivinationCard>>

    @Query("SELECT * FROM divinationCard_table")
    fun getAllCommonDivinationCards(): List<DivinationCard>
}