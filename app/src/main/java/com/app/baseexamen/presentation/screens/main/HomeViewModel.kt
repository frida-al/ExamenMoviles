package com.app.baseexamen.presentation.screens.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.baseexamen.domain.model.CountryName
import com.app.baseexamen.domain.usecase.GetByCountryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import com.app.baseexamen.domain.common.Result
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCountryDetailUseCase: GetByCountryUseCase,
) : ViewModel() {
    val countries = listOf(
        CountryName("mexico", "🇲🇽"),
        CountryName("canada", "🇨🇦"),
        CountryName("brazil", "🇧🇷"),
        CountryName("argentina", "🇦🇷"),
        CountryName("spain", "🇪🇸"),
        CountryName("france", "🇫🇷"),
        CountryName("germany", "🇩🇪"),
        CountryName("italy", "🇮🇹"),
        CountryName("japan", "🇯🇵"),
        CountryName("china", "🇨🇳"),
        CountryName("india", "🇮🇳"),
        CountryName("australia", "🇦🇺"),
    )

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun loadCountry(country: String) {
        viewModelScope.launch {
            getCountryDetailUseCase(country).collect { result ->
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