package com.example.projecttest.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.projecttest.data.database.entity.EstateObjectEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class EstateObjectEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val price: String
) {
    companion object {
        const val TABLE_NAME = "list_item_entities"
    }
}

