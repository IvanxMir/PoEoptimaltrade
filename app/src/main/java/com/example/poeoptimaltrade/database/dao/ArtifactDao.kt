package com.example.poeoptimaltrade.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.poeoptimaltrade.database.entity.Artifact

@Dao
interface ArtifactDao {
    @Insert
    fun artifactInsert(artifact: Artifact)

    @Update
    fun artifactUpdate(artifact: Artifact)

    @Delete
    fun artifactDelete(artifact: Artifact)

    @Query("DELETE FROM artifact_table" )
    fun deleteAllArtifacts()

    @Query("SELECT * FROM artifact_table WHERE id = :id")
    fun getArtifact(id: Int): Artifact

    @Query("UPDATE artifact_table SET artifact_league_price = :leaguePrice WHERE artifact_name = :name")
    fun setArtifactLeagueData(name: String, leaguePrice: Float)

    @Query("UPDATE artifact_table SET artifact_standard_price = :standardPrice WHERE artifact_name = :name")
    fun setArtifactStandardData(name: String, standardPrice: Float)

    @Query("SELECT * FROM artifact_table")
    fun getAllArtifacts(): LiveData<List<Artifact>>

    @Query("SELECT * FROM artifact_table")
    fun getAllCommonArtifacts(): List<Artifact>
}