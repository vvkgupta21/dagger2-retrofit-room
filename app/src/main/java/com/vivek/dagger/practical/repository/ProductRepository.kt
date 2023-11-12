package com.vivek.dagger.practical.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vivek.dagger.practical.db.FakerDB
import com.vivek.dagger.practical.models.Products
import com.vivek.dagger.practical.retrofit.FakerAPI
import javax.inject.Inject

class ProductRepository @Inject constructor(private val fakerAPI: FakerAPI, private val fakerDB: FakerDB) {

    private val _products = MutableLiveData<List<Products>>()
    val products: LiveData<List<Products>>
        get() = _products


    suspend fun getProducts(){
        val result = fakerAPI.getProducts()
        if (result.isSuccessful && result.body() != null){
            fakerDB.getFakerDAO().adProduct(result.body()!!)
            _products.postValue(result.body())
        }
    }
}