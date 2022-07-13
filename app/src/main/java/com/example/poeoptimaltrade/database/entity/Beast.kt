package com.example.poeoptimaltrade.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "beast_table")
data class Beast(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "beast_name")
    var name: String? = null,

    @ColumnInfo(name = "beast_league_price")
    var leaguePrice: Float? = 0.0f,

    @ColumnInfo(name = "beast_standard_price")
    var standardPrice: Float? = 0.0f,

    @ColumnInfo(name = "beast_img_url")
    var img_url: String? = null
)
