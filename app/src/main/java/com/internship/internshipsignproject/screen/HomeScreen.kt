package com.internship.internshipsignproject.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    navigateToSignIn: () -> Unit = {},
    navigateToSignUp: () -> Unit = {}
) {
    val localConfig = LocalConfiguration.current
    val width = localConfig.screenWidthDp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Center
    ) {
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}