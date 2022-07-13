package com.example.poeoptimaltrade.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "artifact_table")
data class Artifact(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "artifact_name")
    var name: String? = null,

    @ColumnInfo(name = "artifact_league_price")
    var leaguePrice: Float? = 0.0f,

    @ColumnInfo(name = "artifact_standard_price")
    var standardPrice: Float? = 0.0f,

    @ColumnInfo(name = "artifact_img_url")
    var img_url: String? = null
)
