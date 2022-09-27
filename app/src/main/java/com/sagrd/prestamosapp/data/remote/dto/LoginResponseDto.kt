package com.sagrd.prestamosapp.data.remote.dto

data class LoginResponseDto(
    val accountID: String="",
    val cedula: String="",
    val customerId: String="",
    val email: String="",
    val firstName: String="",
    val lastName: String="",
    val numero: String="",
    val sagUser: String="",
    val token: String="",
    val userId: String=""
)