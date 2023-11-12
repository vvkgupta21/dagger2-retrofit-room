package com.vivek.dagger.practical.retrofit

import com.vivek.dagger.practical.models.Products
import retrofit2.Response
import retrofit2.http.GET

interface  FakerAPI {
    @GET("products")
    suspend fun getProducts() : Response<List<Products>>
}