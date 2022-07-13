package com.example.poeoptimaltrade.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.poeoptimaltrade.database.entity.Category

@Dao
interface CategoryDao {
    @Insert
    fun categoryInsert(category: Category)

    @Update
    fun categoryUpdate(category: Category)

    @Delete
    fun categoryDelete(category: Category)

    @Query("DELETE FROM categories_table" )
    fun deleteAllCategories()

    @Query("SELECT * FROM categories_table WHERE categoryId = :id")
    fun getCategory(id: Int): Category

    @Query("SELECT * FROM categories_table")
    fun getAllCategories(): LiveData<List<Category>>

    @Query("SELECT * FROM categories_table")
    fun getAllCommonCategories(): List<Category>
}