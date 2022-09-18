package com.sagrd.prestamosapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sagrd.prestamosapp.data.local.dao.OcupacionDao
import com.sagrd.prestamosapp.data.local.dao.PersonaDao
import com.sagrd.prestamosapp.data.local.entity.Ocupacion
import com.sagrd.prestamosapp.data.local.entity.Persona

@Database(
    entities = [
        Ocupacion::class,
        Persona::class
    ],
    version = 1,
    exportSchema = false
)
abstract class PrestamosDb : RoomDatabase() {
    abstract val ocupacionDao: OcupacionDao
    abstract val personaDao: PersonaDao
}

