package com.sagrd.prestamosapp.data.local.dao

import androidx.room.*
import com.sagrd.prestamosapp.data.local.entity.Persona
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(persona: Persona)

    @Delete
    suspend fun delete(persona: Persona)

    @Query("SELECT * " +
            "FROM Personas " +
            "WHERE OcupacionId = :personaId " +
            "LIMIT 1")
    suspend fun find(personaId: Int): Persona

    @Query("SELECT * FROM Personas")
    fun getList(): Flow<List<Persona>>
}