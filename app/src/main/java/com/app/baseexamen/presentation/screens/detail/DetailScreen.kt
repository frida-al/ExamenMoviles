package com.app.baseexamen.presentation.screens.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Suppress("ktlint:standard:function-naming")
@Composable
fun DetailScreen(
    country: String,
    navController: NavController,
    modifier: Modifier = Modifier,

) { // TODO: Crear HomePage
    Scaffold { _ ->
        Box(
            modifier =
                modifier
                    .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = "🚧 En construcción 🚧",
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.headlineMedium,
            )
        }
    }
}