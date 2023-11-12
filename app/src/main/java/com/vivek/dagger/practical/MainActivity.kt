package com.vivek.dagger.practical

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.vivek.dagger.practical.databinding.ActivityMainBinding
import com.vivek.dagger.practical.di.ApplicationComponent
import com.vivek.dagger.practical.viewModels.MainViewModel
import com.vivek.dagger.practical.viewModels.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val applicationComponent = (application as FakerApplication).applicationComponent
        applicationComponent.inject(this)
        mainViewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        mainViewModel.productsLivedata.observe(this, Observer {
            binding.products.text = it.joinToString { x -> x.title + "\n\n" }
        })
    }
}