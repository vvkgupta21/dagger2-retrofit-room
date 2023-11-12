package com.vivek.dagger.practical.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vivek.dagger.practical.models.Products
import com.vivek.dagger.practical.repository.ProductRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: ProductRepository, private val random: Random) : ViewModel() {

    val productsLivedata: LiveData<List<Products>>
        get() = repository.products

    init {
        viewModelScope.launch {
            repository.getProducts()
        }
    }
}

class Random @Inject constructor(){
    fun doAction(){
        Log.d("TAG", "doAction: ")
    }
}