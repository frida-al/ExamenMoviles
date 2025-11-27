package com.app.baseexamen.presentation.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.app.baseexamen.ui.organisms.CardList

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel(),
    //onNavigateToDetail: (String) -> Unit
) {
    val countries = viewModel.countries

    CardList(
        items = countries,
        onCardClick = { country ->
           // onNavigateToDetail(country.country)
        }
    )
}
