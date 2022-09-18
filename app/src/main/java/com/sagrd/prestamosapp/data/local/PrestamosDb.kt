package com.sagrd.prestamosapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sagrd.prestamosapp.data.local.dao.OcupacionDao
import com.sagrd.prestamosapp.data.local.entity.Ocupacion

@Database(
    entities = [Ocupacion::class],
    version = 2,
    exportSchema = false
)
abstract class PrestamosDb : RoomDatabase() {
    abstract val ocupacionDao: OcupacionDao
}

