package com.pm.jeremiasconforto.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.pm.jeremiasconforto.data.entities.Product

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addProduct(product: Product)

    @Update
    fun updateProduct(product: Product)

    @Query("SELECT * FROM Sofas ORDER BY id DESC")
    fun readAllProducts(): LiveData<List<Product>>

    @Delete
    fun deleteProduct(product: Product)
}