package com.example.testearquitetura.data

class ContactResponse(
    var id: String,
    var name: String,
    var documentNumber: String = "",
    var phone: String = "",
    var age: Int,
    var email: String = "",
    val address: AddressResponse
)

class AddressResponse(
    val id: Int,
    val street: String,
    val number: String,
    val complement: String,
    val neighborhood: String,
    val state: String
)