package com.app.baseexamen.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CountryDataDto (
    @SerializedName("country") val country: String,
    @SerializedName("region") val region: String,
    @SerializedName("cases") val cases: Map<String, CaseDto>
)

data class CaseDto (
    val total: Int,
    val new: Int,
)