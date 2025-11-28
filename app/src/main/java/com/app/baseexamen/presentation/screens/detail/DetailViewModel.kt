package com.app.baseexamen.presentation.screens.detail

import android.util.Log
import kotlinx.coroutines.flow.MutableStateFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.baseexamen.domain.common.Result
import com.app.baseexamen.domain.usecase.GetByCountryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getCountryDataUseCase: GetByCountryUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(DetailUiState())
    val uiState: StateFlow<DetailUiState> = _uiState.asStateFlow()

    fun loadCountry(country: String) {
        viewModelScope.launch {
           getCountryDataUseCase(country).collect {
               result ->
               _uiState.update { state ->
                   when (result) {
                       is Result.Loading -> {
                           Log.d("HomeVM", "pais: $country")
                           state.copy(
                               isLoading = true,
                               error = null
                           )
                       }

                       is Result.Success -> {
                           Log.d("HomeVM", "data a devolver: ${result.data}")
                           state.copy(
                               isLoading = false,
                               error = null,
                               countryDetail = result.data
                           )
                       }

                       is Result.Error -> {
                           state.copy(
                               isLoading = false,
                               error = result.exception.message
                           )
                       }
                   }

               }
           }
        }
    }
}


