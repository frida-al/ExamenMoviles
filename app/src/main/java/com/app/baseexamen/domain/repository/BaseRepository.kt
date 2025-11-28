package com.app.baseexamen.domain.repository

import com.app.baseexamen.domain.model.CountryData
import com.app.baseexamen.domain.common.Result


interface BaseRepository {
    suspend fun getByCountry(country: String): CountryData
}