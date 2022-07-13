package com.example.poeoptimaltrade.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currency_table")
data class Currency(
    @PrimaryKey(autoGenerate = true)
    var currencyId: Int = 0,

    @ColumnInfo(name = "currency_name")
    var name: String? = null,

    @ColumnInfo(name = "currency_league_price")
    var leaguePrice: Float? = 0.0f,

    @ColumnInfo(name = "currency_standard_price")
    var standardPrice: Float? = 0.0f,

    @ColumnInfo(name = "currency_img_url")
    var img_url: String? = null)