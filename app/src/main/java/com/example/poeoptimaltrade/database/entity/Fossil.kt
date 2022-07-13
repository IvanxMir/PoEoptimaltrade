package com.example.poeoptimaltrade.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fossil_table")
data class Fossil(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "fossil_name")
    var name: String? = null,

    @ColumnInfo(name = "fossil_league_price")
    var leaguePrice: Float? = 0.0f,

    @ColumnInfo(name = "fossil_standard_price")
    var standardPrice: Float? = 0.0f,

    @ColumnInfo(name = "fossil_img_url")
    var img_url: String? = null
)
