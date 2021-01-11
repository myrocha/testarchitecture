package com.example.testearquitetura.di

import com.example.testearquitetura.data.ContactMapper
import com.example.testearquitetura.domain.ContactRepository
import com.example.testearquitetura.data.ContactRepositoryImpl
import com.example.testearquitetura.ui.presentation.ContactViewModel
import com.example.testearquitetura.ui.presentation.ContactMapperVO
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val contactModule = module {

    viewModel {
        ContactViewModel(
            get(),
            get()
        )
    }

    factory<ContactRepository> {
        ContactRepositoryImpl(
            get()
        )
    }

    factory { ContactMapper() }
    factory { ContactMapperVO() }


}