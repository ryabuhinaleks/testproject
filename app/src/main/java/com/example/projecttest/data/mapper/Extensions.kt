package com.example.projecttest.data.mapper

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.projecttest.data.database.entity.EstateObjectEntity
import com.example.projecttest.domain.model.EstateObject

fun EstateObject.toDB() = EstateObjectEntity(id = id, name = name, price = price)

fun EstateObjectEntity.toDomain() = EstateObject(id = id, name = name, price = price)

fun LiveData<List<EstateObjectEntity>>.toDomain() =
    map { entities -> entities.map { it.toDomain() } }