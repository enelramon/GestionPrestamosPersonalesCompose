package com.sagrd.prestamosapp.data.repository

import com.sagrd.prestamosapp.data.remote.PrestamosApi
import com.sagrd.prestamosapp.data.remote.dto.LoginResponseDto
import javax.inject.Inject

class EjemploApiRepository @Inject constructor(
    private val api: PrestamosApi
) {
    suspend fun Login(username: String, password: String): LoginResponseDto {

        return api.Login(username, password)
    }
}
