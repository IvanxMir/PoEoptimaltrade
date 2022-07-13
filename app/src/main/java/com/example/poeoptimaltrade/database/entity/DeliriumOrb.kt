package com.example.poeoptimaltrade.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "deliriumOrb_table")
data class DeliriumOrb(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "deliriumOrb_name")
    var name: String? = null,

    @ColumnInfo(name = "deliriumOrb_league_price")
    var leaguePrice: Float? = 0.0f,

    @ColumnInfo(name = "deliriumOrb_standard_price")
    var standardPrice: Float? = 0.0f,

    @ColumnInfo(name = "deliriumOrb_img_url")
    var img_url: String? = null
)
