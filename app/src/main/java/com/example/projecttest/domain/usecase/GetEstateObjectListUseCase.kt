package com.example.projecttest.domain.usecase

import androidx.lifecycle.LiveData
import com.example.projecttest.domain.model.EstateObject
import com.example.projecttest.domain.repository.EstateObjectRepository
import javax.inject.Inject

class GetEstateObjectListUseCase @Inject constructor(
    private val estateObjectRepository: EstateObjectRepository
) {

    fun execute(): LiveData<List<EstateObject>> {
        return estateObjectRepository.getEstateObjectList()
    }
}