package com.app.baseexamen.presentation.screens.main

import com.app.baseexamen.domain.model.CountryData

data class HomeUiState (
    val isLoading: Boolean = false,
    val countryDetail: CountryData? = null,
    val error: String? = null
)