package com.example.projecttest.domain.usecase

import com.example.projecttest.domain.model.EstateObject
import com.example.projecttest.domain.repository.EstateObjectRepository

class DeleteEstateObjectUseCase(
    private val estateObjectRepository: EstateObjectRepository
) {

    suspend fun execute(item: EstateObject) {
        estateObjectRepository.deleteEstateObject(item)
    }
}