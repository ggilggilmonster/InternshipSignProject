package com.internship.internshipsignproject.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.internship.internshipsignproject.data.UserData
import kotlinx.coroutines.flow.MutableStateFlow

class SignUpViewModel: ViewModel() {
    private val _idState = MutableStateFlow("")
    private val _pwState = MutableStateFlow("")
    private val _nameState = MutableStateFlow("")

    fun saveUserData(
        id: String,
        pw: String,
        name: String
    ) {
        _idState.value = id
        _pwState.value = pw
        _nameState.value = name
    }

    fun signUp(
        onSuccess: () -> Unit,
        onFailure: (Exception?) -> Unit
    ) {
        val fireStore = FirebaseFirestore.getInstance()

        fireStore.collection("user").document(_idState.value).set(
            UserData(
                id = _idState.value,
                pw = _pwState.value,
                name = _nameState.value
            )
        ).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                onSuccess()
            } else {
                onFailure(task.exception)
            }
        }
    }
}