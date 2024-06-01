package com.example.projecttest.domain.repository

import androidx.lifecycle.LiveData
import com.example.projecttest.domain.model.EstateObject

interface EstateObjectRepository {

    fun getEstateObjectList(): LiveData<List<EstateObject>>

    suspend fun getEstateDetailObjectById(id: Int): EstateObject

    suspend fun getEstateAddObject(item: EstateObject)

    suspend fun deleteEstateObject(item: EstateObject)
}