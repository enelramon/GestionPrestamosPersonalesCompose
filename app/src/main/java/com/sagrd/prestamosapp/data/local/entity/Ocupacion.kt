package com.sagrd.prestamosapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="Ocupaciones")
data class Ocupacion(
    @PrimaryKey(autoGenerate = true)
    val ocupacionId: Int=0,
    val descripcion: String,
    val salario: Double
)


