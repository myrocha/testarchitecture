package com.example.testearquitetura.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.observe
import com.example.testearquitetura.databinding.ContactActivityBinding
import com.example.testearquitetura.ui.presentation.ContactViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ContactActivity : AppCompatActivity() {

    private val viewModel: ContactViewModel by viewModel()
    private lateinit var binding: ContactActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ContactActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupObserver()
        viewModel.fetchContact()
    }

    private fun setupObserver() {
        viewModel.contactLiveData.observe(this) { state ->
            when (state) {
                is ContactViewModel.ContactState.Loading -> toggleProgressDialog(true)
                is ContactViewModel.ContactState.Success -> {
                    binding.cvContact.bind(state.data)
                    toggleProgressDialog(false)
                }
            }
        }
    }

    private fun toggleProgressDialog(show: Boolean) {
        binding.pbLoading.isVisible = show
    }
}