package com.example.poeoptimaltrade.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "oil_table")
data class Oil(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "oil_name")
    var name: String? = null,

    @ColumnInfo(name = "oil_league_price")
    var leaguePrice: Float? = 0.0f,

    @ColumnInfo(name = "oil_standard_price")
    var standardPrice: Float? = 0.0f,

    @ColumnInfo(name = "oil_img_url")
    var img_url: String? = null
)
