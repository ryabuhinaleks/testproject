package com.example.projecttest.presentation.screen.add

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.projecttest.domain.model.EstateObject
import com.example.projecttest.domain.usecase.GetEstateAddObjectUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class EstateAddViewModel @Inject constructor(
    private val getEstateAddObjectUseCase: GetEstateAddObjectUseCase
) : ViewModel() {

    val closeScreen = MutableLiveData<Boolean>()

    fun addEstateObject(price: String, address: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                getEstateAddObjectUseCase.execute(
                    EstateObject(id = ESTATE_NEW_ID, price = price, name = address)
                )
                closeScreen.postValue(true)
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    class Factory @Inject constructor(
        private val getEstateAddObjectUseCase: GetEstateAddObjectUseCase
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return EstateAddViewModel(
                getEstateAddObjectUseCase = getEstateAddObjectUseCase
            ) as T
        }
    }

    companion object {
        const val ESTATE_NEW_ID = 0
    }
}