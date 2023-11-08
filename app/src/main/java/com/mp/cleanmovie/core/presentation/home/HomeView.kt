package com.mp.cleanmovie.core.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun HomeNavigate(
    navController: NavHostController,
) {
    HomeContent(
        viewModel = hiltViewModel()
    )
}

@Composable
fun HomeContent(
    viewModel: HomeViewModel,
) {
    HomeScreen()
}
@Composable
private fun HomeScreen(){

    Column(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            text ="home",
            maxLines = 1,
            fontSize = MaterialTheme.typography.labelMedium.fontSize,
            fontWeight = FontWeight.Medium
        )
    }
}



