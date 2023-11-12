package com.vivek.dagger.practical.di

import android.content.Context
import androidx.room.Room
import com.vivek.dagger.practical.db.FakerDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideFakerDB(context: Context): FakerDB{
        return Room.databaseBuilder(context, FakerDB::class.java, "FakerDB").build()
    }

}