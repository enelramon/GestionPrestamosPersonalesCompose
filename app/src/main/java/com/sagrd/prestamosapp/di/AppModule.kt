package com.sagrd.prestamosapp.di

import android.content.Context
import androidx.room.Room
import com.sagrd.prestamosapp.data.local.PrestamosDb
import com.sagrd.prestamosapp.data.remote.SagApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
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

    @Singleton
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi
            .Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Singleton
    @Provides
    fun provideSagApi(moshi: Moshi): SagApi {
        return Retrofit.Builder()
            .baseUrl("https://apisagwallet.sagrd.com/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(SagApi::class.java)
    }
}