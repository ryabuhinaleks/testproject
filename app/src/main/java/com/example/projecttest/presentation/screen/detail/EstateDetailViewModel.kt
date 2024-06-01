package com.example.projecttest.presentation.screen.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projecttest.data.repository.EstateObjectRepositoryImpl
import com.example.projecttest.domain.model.EstateObject
import com.example.projecttest.domain.usecase.GetEstateDetailObjectUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class EstateDetailViewModel() : ViewModel() {

    // Without DI
    private val repository = EstateObjectRepositoryImpl()

    private val getEstateDetailObjectUseCase = GetEstateDetailObjectUseCase(repository)

    val estateObject = MutableLiveData<EstateObject>()

    private val scope = CoroutineScope(Dispatchers.IO)

    fun getEstateObjectById(id: Int) {
        scope.launch {
            estateObject.postValue(getEstateDetailObjectUseCase.execute(id))
        }
    }

    override fun onCleared() {
        super.onCleared()
        scope.cancel()
    }
}