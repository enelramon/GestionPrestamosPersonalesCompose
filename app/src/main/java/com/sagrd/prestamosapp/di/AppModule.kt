package com.sagrd.prestamosapp.di

import android.content.Context
import androidx.room.Room
import com.sagrd.prestamosapp.data.local.PrestamosDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providesDatabase(@ApplicationContext context: Context): PrestamosDb {
        val DATABASE_NAME = "Prestamos.db"

        return Room.databaseBuilder(
            context,
            PrestamosDb::class.java,
            DATABASE_NAME
        ).fallbackToDestructiveMigration()
            .build()
    }
}