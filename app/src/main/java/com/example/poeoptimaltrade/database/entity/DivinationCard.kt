package com.example.poeoptimaltrade.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "divinationCard_table")
data class DivinationCard(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "divinationCard_name")
    var name: String? = null,

    @ColumnInfo(name = "divinationCard_league_price")
    var leaguePrice: Float? = 0.0f,

    @ColumnInfo(name = "divinationCard_standard_price")
    var standardPrice: Float? = 0.0f,

    @ColumnInfo(name = "divinationCard_img_url")
    var img_url: String? = null
)
