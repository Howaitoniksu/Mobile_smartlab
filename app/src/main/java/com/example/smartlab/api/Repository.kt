package com.example.smartlab.api

import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun sendCodeEmail(email:String): Flow<Result<String>>

    suspend fun signInCode(code:String, email: String): Flow<Result<String>>
}