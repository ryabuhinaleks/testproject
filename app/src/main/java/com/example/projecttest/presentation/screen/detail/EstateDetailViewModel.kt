package com.example.projecttest.presentation.screen.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.projecttest.domain.model.EstateObject
import com.example.projecttest.domain.usecase.GetEstateDetailObjectUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class EstateDetailViewModel @Inject constructor(
    private val getEstateDetailObjectUseCase: GetEstateDetailObjectUseCase
) : ViewModel() {

    val estateObject = MutableLiveData<EstateObject>()

    fun getEstateObjectById(id: Int) {
        viewModelScope.launch {
            estateObject.postValue(getEstateDetailObjectUseCase.execute(id))
        }
    }

    @Suppress("UNCHECKED_CAST")
    class Factory @Inject constructor(
        private val getEstateDetailObjectUseCase: GetEstateDetailObjectUseCase
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return EstateDetailViewModel(
                getEstateDetailObjectUseCase = getEstateDetailObjectUseCase
            ) as T
        }
    }
}