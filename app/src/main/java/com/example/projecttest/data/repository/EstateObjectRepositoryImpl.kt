package com.example.projecttest.data.repository

import androidx.lifecycle.LiveData
import com.example.projecttest.data.database.dao.EstateObjectDao
import com.example.projecttest.data.mapper.toDB
import com.example.projecttest.data.mapper.toDomain
import com.example.projecttest.domain.model.EstateObject
import com.example.projecttest.domain.repository.EstateObjectRepository
import javax.inject.Inject

class EstateObjectRepositoryImpl @Inject constructor(
    private val estateObjectDao: EstateObjectDao
) : EstateObjectRepository {

    override fun getEstateObjectList(): LiveData<List<EstateObject>> {
        return estateObjectDao.getList().toDomain()
    }

    override suspend fun getEstateDetailObjectById(id: Int): EstateObject {
        return estateObjectDao.getEstateObjectById(id).toDomain()
    }

    override suspend fun getEstateAddObject(item: EstateObject) {
        estateObjectDao.addItem(item.toDB())
    }

    override suspend fun deleteEstateObject(item: EstateObject) {
        estateObjectDao.deleteItems(item.toDB())
    }
}