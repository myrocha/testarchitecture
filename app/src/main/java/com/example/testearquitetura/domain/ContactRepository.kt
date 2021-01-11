package com.example.testearquitetura.domain

import io.reactivex.Single

interface ContactRepository {

    fun fetchContact() : Single<Contact>
}