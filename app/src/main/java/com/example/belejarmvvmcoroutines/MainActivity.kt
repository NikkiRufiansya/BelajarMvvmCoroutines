package com.example.belejarmvvmcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.belejarmvvmcoroutines.adapter.MovieAdapter
import com.example.belejarmvvmcoroutines.databinding.ActivityMainBinding

import com.example.belejarmvvmcoroutines.repository.MainRepository
import com.example.belejarmvvmcoroutines.retrofit.RetrofitService
import com.example.belejarmvvmcoroutines.viewmodel.MainViewModel
import com.example.belejarmvvmcoroutines.viewmodel.MyViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    private val adapter = MovieAdapter()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofitService = RetrofitService.create()
        val mainRepository = MainRepository(retrofitService)
        binding.recyclerview.adapter = adapter

        viewModel = ViewModelProvider(this, MyViewModelFactory(mainRepository)).get(MainViewModel::class.java)


        viewModel.movieList.observe(this, {
            adapter.setMovies(it)
        })

        viewModel.errorMessage.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

        viewModel.loading.observe(this, Observer {
            if (it) {
                binding.progressDialog.visibility = View.VISIBLE
            } else {
                binding.progressDialog.visibility = View.GONE
            }
        })

        viewModel.getAllMovies()

    }
}