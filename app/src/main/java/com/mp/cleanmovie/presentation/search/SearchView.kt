package com.mp.cleanmovie.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavHostController


@Composable
fun SearchNavigate(
    navController: NavHostController,
) {
    SearchContent(
        viewModel = hiltViewModel())
}

@Composable
fun SearchContent(
    viewModel: SearchViewModel,
) {
    SearchScreen()
}

@Composable
private fun SearchScreen() {
    Column(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            text ="movie",
            maxLines = 1,
            fontSize = MaterialTheme.typography.labelMedium.fontSize,
            fontWeight = FontWeight.Medium
        )
    }
}

