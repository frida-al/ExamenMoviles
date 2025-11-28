package com.app.baseexamen.domain.model

data class Case (
    val date: String,
    val total: Int,
    val new: Int
)

data class CountryData(
    val country: String,
    val region: String,
    val cases: List<Case>
)

data class CountryName(
    val name: String,
    val flag: String,
)