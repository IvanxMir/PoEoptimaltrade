package com.example.poeoptimaltrade.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories_table")
data class Category(
    @PrimaryKey(autoGenerate = true)
    var categoryId: Int = 0,

    @ColumnInfo(name = "category_name")
    var name: String? = null,

    @ColumnInfo(name = "category_img_url")
    var url: String? = null)