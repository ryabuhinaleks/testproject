package com.example.projecttest.presentation.screen.estatelist

import androidx.lifecycle.ViewModel
import com.example.projecttest.data.repository.EstateObjectRepositoryImpl
import com.example.projecttest.domain.model.EstateObject
import com.example.projecttest.domain.usecase.DeleteEstateObjectUseCase
import com.example.projecttest.domain.usecase.GetEstateAddObjectUseCase
import com.example.projecttest.domain.usecase.GetEstateDetailObjectUseCase
import com.example.projecttest.domain.usecase.GetEstateObjectListUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class EstateListViewModel() : ViewModel() {

    // Without DI
    private val repository = EstateObjectRepositoryImpl()

    private val getEstateObjectListUseCase = GetEstateObjectListUseCase(repository)
    private val deleteEstateObjectUseCase = DeleteEstateObjectUseCase(repository)

    private val scope = CoroutineScope(Dispatchers.IO)

    val estateObjectList = getEstateObjectListUseCase.execute()

    fun deleteEstateObject(item: EstateObject) {
        scope.launch {
            deleteEstateObjectUseCase.execute(item)
        }
    }

    override fun onCleared() {
        super.onCleared()
        scope.cancel()
    }
}