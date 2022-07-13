package com.example.poeoptimaltrade.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "resonator_table")
data class Resonator(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "resonator_name")
    var name: String? = null,

    @ColumnInfo(name = "resonator_league_price")
    var leaguePrice: Float? = 0.0f,

    @ColumnInfo(name = "resonator_standard_price")
    var standardPrice: Float? = 0.0f,

    @ColumnInfo(name = "resonator_img_url")
    var img_url: String? = null
)
