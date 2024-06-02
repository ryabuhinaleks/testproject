package com.example.projecttest.domain.usecase

import com.example.projecttest.domain.model.EstateObject
import com.example.projecttest.domain.repository.EstateObjectRepository
import javax.inject.Inject

class GetEstateAddObjectUseCase @Inject constructor(
    private val estateObjectRepository: EstateObjectRepository
) {

    suspend fun execute(item: EstateObject) {
        estateObjectRepository.getEstateAddObject(item)
    }
}