package com.vivek.dagger.practical.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vivek.dagger.practical.models.Products

@Dao
interface FakerDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun adProduct(products: List<Products>)

    @Query("SELECT * FROM products")
    suspend fun getProducts() : List<Products>
}