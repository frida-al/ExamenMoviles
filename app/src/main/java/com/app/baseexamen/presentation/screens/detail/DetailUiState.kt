package com.app.baseexamen.presentation.screens.detail

import com.app.baseexamen.domain.model.CountryData

data class DetailUiState (
    val isLoading: Boolean = false,
    val countryDetail: CountryData? = null,
    val error: String? = null
    )