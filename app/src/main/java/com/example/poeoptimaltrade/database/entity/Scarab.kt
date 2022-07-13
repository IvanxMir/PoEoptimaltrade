package com.example.poeoptimaltrade.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "scarab_table")
data class Scarab(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "scarab_name")
    var name: String? = null,

    @ColumnInfo(name = "scarab_league_price")
    var leaguePrice: Float? = 0.0f,

    @ColumnInfo(name = "scarab_standard_price")
    var standardPrice: Float? = 0.0f,

    @ColumnInfo(name = "scarab_img_url")
    var img_url: String? = null
)
