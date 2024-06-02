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
import javax.inject.Inject

class EstateListViewModel @Inject constructor(
    private val getEstateObjectListUseCase: GetEstateObjectListUseCase,
    private val deleteEstateObjectUseCase: DeleteEstateObjectUseCase
) : ViewModel() {

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