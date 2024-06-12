package com.example.projecttest.presentation.screen.estatelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.projecttest.domain.model.EstateObject
import com.example.projecttest.domain.usecase.DeleteEstateObjectUseCase
import com.example.projecttest.domain.usecase.GetEstateObjectListUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class EstateListViewModel @Inject constructor(
    private val getEstateObjectListUseCase: GetEstateObjectListUseCase,
    private val deleteEstateObjectUseCase: DeleteEstateObjectUseCase
) : ViewModel() {

    val estateObjectList = getEstateObjectListUseCase.execute()

    fun deleteEstateObject(item: EstateObject) {
        viewModelScope.launch {
            deleteEstateObjectUseCase.execute(item)
        }
    }


    @Suppress("UNCHECKED_CAST")
    class Factory @Inject constructor(
        private val getEstateObjectListUseCase: GetEstateObjectListUseCase,
        private val deleteEstateObjectUseCase: DeleteEstateObjectUseCase
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return EstateListViewModel(
                getEstateObjectListUseCase = getEstateObjectListUseCase,
                deleteEstateObjectUseCase = deleteEstateObjectUseCase
            ) as T
        }
    }
}