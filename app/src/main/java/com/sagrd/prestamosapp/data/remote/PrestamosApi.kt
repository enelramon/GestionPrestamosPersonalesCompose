package com.sagrd.prestamosapp.data.remote

import com.sagrd.prestamosapp.data.remote.dto.LoginResponseDto
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface PrestamosApi {
    @POST("api/Login")
    suspend fun Login(
        @Query("username") username:String,
        @Query("password") password:String
    ): LoginResponseDto

}



