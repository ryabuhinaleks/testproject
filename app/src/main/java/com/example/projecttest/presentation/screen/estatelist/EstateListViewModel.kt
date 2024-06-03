package com.example.projecttest.presentation.screen.estatelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.projecttest.domain.model.EstateObject
import com.example.projecttest.domain.usecase.DeleteEstateObjectUseCase
import com.example.projecttest.domain.usecase.GetEstateObjectListUseCase
import com.example.projecttest.presentation.root.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class EstateListViewModel @Inject constructor(
    private val getEstateObjectListUseCase: GetEstateObjectListUseCase,
    private val deleteEstateObjectUseCase: DeleteEstateObjectUseCase
) : BaseViewModel() {

    val estateObjectList = getEstateObjectListUseCase.execute()

    fun deleteEstateObject(item: EstateObject) {
        scope.launch {
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