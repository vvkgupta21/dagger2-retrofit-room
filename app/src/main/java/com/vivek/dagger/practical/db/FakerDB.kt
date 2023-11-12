package com.vivek.dagger.practical.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vivek.dagger.practical.models.Products

@Database(entities = [Products::class], version = 1)
abstract class FakerDB : RoomDatabase() {

    abstract fun getFakerDAO(): FakerDAO

}