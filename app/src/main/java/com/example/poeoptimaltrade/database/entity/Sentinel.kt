package com.example.poeoptimaltrade.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sentinel_table")
data class Sentinel(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "sentinel_name")
    var name: String? = null,

    @ColumnInfo(name = "sentinel_league_price")
    var leaguePrice: Float? = 0.0f,

    @ColumnInfo(name = "sentinel_standard_price")
    var standardPrice: Float? = 0.0f,

    @ColumnInfo(name = "sentinel_img_url")
    var img_url: String? = null
)
