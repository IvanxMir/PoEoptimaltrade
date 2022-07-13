package com.example.poeoptimaltrade.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vial_table")
data class Vial(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "vial_name")
    var name: String? = null,

    @ColumnInfo(name = "vial_league_price")
    var leaguePrice: Float? = 0.0f,

    @ColumnInfo(name = "vial_standard_price")
    var standardPrice: Float? = 0.0f,

    @ColumnInfo(name = "vial_img_url")
    var img_url: String? = null
)
