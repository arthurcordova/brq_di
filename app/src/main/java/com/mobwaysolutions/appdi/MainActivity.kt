package com.mobwaysolutions.appdi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.mobwaysolutions.appdi.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.errorTitulo.observe(this) {
            binding.etServicoTitulo.error = it
        }
        viewModel.errorPreco.observe(this) {
            binding.etServicoPreco.error = it
        }
        viewModel.statusTela.observe(this) {
            when (it) {
                is MainInteractions.Error -> {

                }
                MainInteractions.Loading -> {

                }
                MainInteractions.Success -> {

                }
            }
        }

        binding.buttonSave.setOnClickListener {
            ServicoEntity(
                binding.etServicoTitulo.text.toString(),
                binding.etServicoPreco.text.toString()
            ).apply {
                viewModel.saveService(this)
            }
        }
    }
}