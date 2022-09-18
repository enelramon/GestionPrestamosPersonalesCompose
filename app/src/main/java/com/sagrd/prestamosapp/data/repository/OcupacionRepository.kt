package com.sagrd.prestamosapp.data.repository

import com.sagrd.prestamosapp.data.local.PrestamosDb
import com.sagrd.prestamosapp.data.local.entity.Ocupacion
import javax.inject.Inject

class OcupacionRepository @Inject constructor(
    private val db: PrestamosDb
) {
    suspend fun insert(ocupacion: Ocupacion) = db.ocupacionDao.insert(ocupacion)
    suspend fun delete(ocupacion: Ocupacion) = db.ocupacionDao.delete(ocupacion)
    suspend fun find(id: Int) = db.ocupacionDao.find(id)
    fun getList() = db.ocupacionDao.getList()
}