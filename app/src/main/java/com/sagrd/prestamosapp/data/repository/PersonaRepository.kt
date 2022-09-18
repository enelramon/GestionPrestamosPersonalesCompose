package com.sagrd.prestamosapp.data.repository

import com.sagrd.prestamosapp.data.local.PrestamosDb
import com.sagrd.prestamosapp.data.local.entity.Persona
import javax.inject.Inject

class PersonaRepository @Inject constructor(
    private val db: PrestamosDb
) {
    suspend fun insert(persona: Persona) = db.personaDao.insert(persona)
    suspend fun delete(persona: Persona) = db.personaDao.delete(persona)
    suspend fun find(id: Int) = db.personaDao.find(id)
     fun getList() = db.personaDao.getList()
}

