package com.app.baseexamen.data.mapper

import com.app.baseexamen.data.remote.dto.CountryDataDto
import com.app.baseexamen.domain.model.Case
import com.app.baseexamen.domain.model.CountryData

fun CountryDataDto.toDomain(): CountryData {
    return CountryData(
        country = country,
        region = region,
        cases= cases.map { (date, caseDto) ->
            Case(
                date = date,
                total = caseDto.total,
                new = caseDto.new
            )

        }
    )
}

fun List<CountryDataDto>.toDomain(): List<CountryData>{
    return this.map {it.toDomain() }
}