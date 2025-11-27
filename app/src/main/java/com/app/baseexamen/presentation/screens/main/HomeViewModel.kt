package com.app.baseexamen.presentation.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.baseexamen.domain.model.CountryData
import com.app.baseexamen.domain.model.CountryName
import com.app.baseexamen.domain.repository.BaseRepository
import com.app.baseexamen.domain.usecase.GetListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    //private val getListUseCase: GetListUseCase,
) : ViewModel() {
        val countries = listOf(
            CountryName("Mexico"),
            CountryName("Canada"),
            CountryName("USA"),
            CountryName("Brazil"),
            CountryName("Argentina"),
            CountryName("Spain"),
            CountryName("France"),
            CountryName("Germany"),
            CountryName("Italy"),
            CountryName("Japan"),
            CountryName("China"),
            CountryName("India"),
            CountryName("Australia"),
            CountryName("UK"),
            CountryName("South Africa")
        )
    }
/*
    private val _countries = MutableStateFlow<List<CountryData>>(emptyList())
    val countries: StateFlow<List<CountryData>> = _countries.asStateFlow()
    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun loadCountries(country: String = "Canada") {
        viewModelScope.launch {
            getListUseCase(country)
            result.fold(
                onSuccess = { data ->
                    _countries.value = data
                },
                onFailure = { exception ->
                    _error.value = exception.message ?: "Error desconocido"
                }
            )
        }
    }

    fun loadCountriesByDate(date: String) {
        viewModelScope.launch {
            _error.value = null
            val result = repository.getByDate(date)
            result.fold(
                onSuccess = { data ->
                    _countries.value = data
                },
                onFailure = { exception ->
                    _error.value = exception.message ?: "Error desconocido"
                }
            )
        }
    }
}*/