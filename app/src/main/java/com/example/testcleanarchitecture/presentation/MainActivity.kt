package com.example.testcleanarchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.testcleanarchitecture.app.App
import com.example.testcleanarchitecture.data.repository.UserRepositoryImpl
import com.example.testcleanarchitecture.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.testcleanarchitecture.databinding.ActivityMainBinding
import com.example.testcleanarchitecture.domain.UserRepository
import com.example.testcleanarchitecture.domain.models.SaveUserNameParam
import com.example.testcleanarchitecture.domain.usecase.GetUserNameUseCase
import com.example.testcleanarchitecture.domain.usecase.SaveUserNameUseCase
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var vmFactory: MainViewModelFactory
    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (applicationContext as App).appComponent.inject(this)
        viewModel = ViewModelProvider(this, vmFactory)[MainViewModel::class.java]



        binding.receiveButton.setOnClickListener {
            viewModel.load()

        }

        viewModel.resultLive.observe(this, Observer {
            binding.dataTextView.text = it
        })

        binding.sendButton.setOnClickListener {
            viewModel.save(binding.dataEditText.text.toString())

        }


    }
}