package com.example.testearquitetura.data

import com.example.testearquitetura.domain.Contact
import com.example.testearquitetura.domain.ContactRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class ContactRepositoryImpl(private val contactMapper: ContactMapper):
    ContactRepository {

    override fun fetchContact() : Single<Contact> {
        return Single.just(contactMapper.contactResponseToModel(
            ContactResponse(
                id = "223",
                name = "José Silva Pereira",
                documentNumber = "34569-00",
                phone = "(11) 92198877",
                age = 54,
                email = "",
                address = AddressResponse(
                    id = 2588,
                    street = "Rua Andrade José",
                    number = "4566",
                    complement = "apt 104",
                    neighborhood = "Santo Amaro",
                    state = "sp"
                )
            )
        )).subscribeOn(Schedulers.io())
    }
}