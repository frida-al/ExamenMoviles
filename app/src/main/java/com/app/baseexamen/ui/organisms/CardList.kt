package com.app.baseexamen.ui.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.app.baseexamen.domain.model.CountryData
import com.app.baseexamen.domain.model.CountryName
import com.app.baseexamen.ui.molecules.SimpleCard

@Composable
fun CardList(
    items: List<CountryName>,
    onCardClick: (CountryName) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(
            items = items,
            key = { it.name }
        ) { countryName ->
            SimpleCard(
                onClick = { onCardClick(countryName) },
            ) {
                Text(
                    text = countryName.name,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}
