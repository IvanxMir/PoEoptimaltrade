package com.example.poeoptimaltrade.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fragment_table")
data class Fragment (
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0,

        @ColumnInfo(name = "fragment_name")
        var name: String? = null,

        @ColumnInfo(name = "fragment_league_price")
        var leaguePrice: Float? = 0.0f,

        @ColumnInfo(name = "fragment_standard_price")
        var standardPrice: Float? = 0.0f,

        @ColumnInfo(name = "fragment_img_url")
        var img_url: String? = null
)