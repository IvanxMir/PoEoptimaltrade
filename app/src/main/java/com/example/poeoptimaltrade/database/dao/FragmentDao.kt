package com.example.poeoptimaltrade.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.poeoptimaltrade.database.entity.Currency
import com.example.poeoptimaltrade.database.entity.Fragment

@Dao
interface FragmentDao {
    @Insert
    fun fragmentInsert(fragment: Fragment)

    @Update
    fun fragmentUpdate(fragment: Currency)

    @Delete
    fun fragmentDelete(fragment: Currency)

    @Query("DELETE FROM fragment_table" )
    fun deleteAllFragments()

    @Query("SELECT * FROM fragment_table WHERE id = :id")
    fun getFragment(id: Int): Fragment

    @Query("UPDATE fragment_table SET fragment_league_price = :leaguePrice WHERE fragment_name = :name")
    fun setFragmentLeagueData(name: String, leaguePrice: Float)

    @Query("UPDATE fragment_table SET fragment_standard_price = :standardPrice WHERE fragment_name = :name")
    fun setFragmentStandardData(name: String, standardPrice: Float)

    @Query("SELECT * FROM fragment_table")
    fun getAllFragment(): LiveData<List<Fragment>>

    @Query("SELECT * FROM fragment_table")
    fun getAllCommonFragment(): List<Fragment>
}