package com.internship.internshipsignproject.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.internship.internshipsignproject.viewmodel.SignUpViewModel

@Composable
fun SignUpScreen(
    signUpViewModel: SignUpViewModel = viewModel<SignUpViewModel>(),
    navigateToSignIn: () -> Unit = {},
    navigateToHome: () -> Unit = {}
) {
    val localContext = LocalContext.current

    val id = remember { mutableStateOf("") }
    val idCheck = remember { mutableStateOf("") }
    val name = remember { mutableStateOf("") }
    val pw = remember { mutableStateOf("") }
    val pwCheck = remember { mutableStateOf("") }

    val idError = remember { mutableStateOf(false) }
    val idCheckError = remember { mutableStateOf(false) }
    val nameError = remember { mutableStateOf(false) }
    val pwError = remember { mutableStateOf(false) }
    val pwCheckError = remember { mutableStateOf(false) }

}

@Preview
@Composable
private fun SignUpScreenPreview() {
    SignUpScreen()
}