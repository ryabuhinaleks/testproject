package com.example.projecttest.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.projecttest.data.database.entity.EstateObjectEntity

@Dao
interface EstateObjectDao {

    @Query("SELECT * from list_item_entities")
    fun getList(): LiveData<List<EstateObjectEntity>>

    @Query("SELECT * from list_item_entities WHERE id=:id LIMIT 1")
    suspend fun getEstateObjectById(id: Int): EstateObjectEntity

    @Delete
    suspend fun deleteItems(estate: EstateObjectEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addItem(estate: EstateObjectEntity)
}