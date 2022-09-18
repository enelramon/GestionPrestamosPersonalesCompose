package com.sagrd.prestamosapp.data.local.dao;


import androidx.room.*;
import com.sagrd.prestamosapp.data.local.entity.Ocupacion
import kotlinx.coroutines.flow.Flow;

@Dao
interface OcupacionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(ocupacion: Ocupacion)

    @Delete
    suspend fun delete(ocupacion: Ocupacion)

    @Query("SELECT * " +
            "FROM Ocupaciones " +
            "WHERE OcupacionId = :ocupacionId " +
            "LIMIT 1")
    suspend fun find(ocupacionId: Int): Ocupacion

    @Query("SELECT * FROM Ocupaciones")
    fun getList(): Flow<List<Ocupacion>>
}

