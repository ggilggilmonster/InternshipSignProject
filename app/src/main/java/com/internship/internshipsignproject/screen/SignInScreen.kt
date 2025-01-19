package com.internship.internshipsignproject.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.internship.internshipsignproject.viewmodel.SignInViewModel

@Composable
fun SignInScreen(
    signInViewModel: SignInViewModel = viewModel<SignInViewModel>(),
    navigateToHome: () -> Unit = {}
) {
    val id = remember { mutableStateOf("") }
    val pw = remember { mutableStateOf("") }

    val idError = remember { mutableStateOf(false) }
    val pwError = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterStart
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = "btn_backStack",
                modifier = Modifier
                    .clickable { navigateToHome() }
                    .padding(vertical = 20.dp, horizontal = 16.dp)
            )

            Text(
                text = "InternshipSignProject",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            )
        }

        Icon(
            imageVector = Icons.Default.Lock,
            contentDescription = "자물쇠",
            modifier = Modifier
                .padding(top = 36.dp)
                .size(50.dp)
        )


        Text(
            text = "인턴십 로그인 페이지에 오신 걸 환영합니다.",
            modifier = Modifier.padding(top = 24.dp, bottom = 12.dp),
            style = TextStyle(
                color = Color.Gray,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            ),
            textAlign = TextAlign.Center
        )

        TextField(
            value = id.value,
            onValueChange = { id.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 28.dp, start = 24.dp, end = 24.dp),
            label = { Text(text = "아이디") },
            placeholder = { Text(text = "아이디를 입력하시오.") },
            trailingIcon = {
                IconButton(onClick = { id.value = "" }) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "ID clear button")
                }
            },
            supportingText = {
                if (idError.value) Text(text = "입력하신 아이디가 없습니다.")
            },
            isError = idError.value,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0x1A0000FF),
                unfocusedContainerColor = Color.Blue,
                focusedIndicatorColor = Color.Blue
            )
        )

        TextField(
            value = pw.value,
            onValueChange = { pw.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, start = 24.dp, end = 24.dp),
            label = { Text(text = "비밀번호") },
            placeholder = { Text(text = "비밀번호를 입력하시오.") },
            trailingIcon = {
                IconButton(onClick = { pw.value = "" }) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "PW clear button")
                }
            },
            supportingText = {
                if (pwError.value) Text(text = "입력하신 비밀번호가 없습니다.")
            },
            isError = pwError.value,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0x1A0000FF),
                unfocusedContainerColor = Color.Blue,
                focusedIndicatorColor = Color.Blue
            )
        )

        Spacer(modifier = Modifier.weight(1f))























































    }
}

@Preview
@Composable
private fun SignInScreenPreview() {
    SignInScreen()
}