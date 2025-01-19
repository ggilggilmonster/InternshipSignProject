package com.internship.internshipsignproject.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.internship.internshipsignproject.data.UserData

class SignInViewModel: ViewModel() {
    fun signIn(
        id: String,
        pw: String,
        onSuccess: (UserData?) -> Unit,
        onFailure: (Exception?) -> Unit
    ) {
        val firestore = FirebaseFirestore.getInstance()
        firestore.collection("user")
            .whereEqualTo("id", id)
            .whereEqualTo("pw", pw)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    if (task.result.documents.size > 0) {
                        val data = task.result.documents.first().toObject(UserData::class.java)
                        onSuccess(data)
                    }
                } else {
                    onFailure(task.exception)
                }
            }
    }
}