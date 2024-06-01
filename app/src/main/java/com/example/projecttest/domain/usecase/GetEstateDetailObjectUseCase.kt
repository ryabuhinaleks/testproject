package com.example.projecttest.domain.usecase

import com.example.projecttest.domain.model.EstateObject
import com.example.projecttest.domain.repository.EstateObjectRepository

class GetEstateDetailObjectUseCase(
    private val estateObjectRepository: EstateObjectRepository
) {

    suspend fun execute(id: Int): EstateObject {
        return estateObjectRepository.getEstateDetailObjectById(id)
    }
}