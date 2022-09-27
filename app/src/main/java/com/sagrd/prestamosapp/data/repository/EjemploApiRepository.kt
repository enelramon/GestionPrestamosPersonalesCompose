package com.sagrd.prestamosapp.data.repository

import com.sagrd.prestamosapp.data.remote.SagApi
import com.sagrd.prestamosapp.data.remote.dto.LoginResponseDto
import javax.inject.Inject

class EjemploApiRepository @Inject constructor(
    private val api: SagApi
) {
    suspend fun Login(username: String, password: String): LoginResponseDto {
        try {
            return api.Login(username, password)
        } catch (e: Exception) {
            throw e
        }

    }
}