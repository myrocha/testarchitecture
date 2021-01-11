package com.example.testearquitetura.data

import com.example.testearquitetura.domain.Contact

class ContactMapper {

    fun contactResponseToModel(contactResponse: ContactResponse) =

        Contact(
            id = contactResponse.id,
            name = contactResponse.name,
            documentNumber = contactResponse.documentNumber,
            phone = contactResponse.phone,
            age = contactResponse.age.toString(),
            email = contactResponse.email,
            street = contactResponse.address.street,
            number = contactResponse.address.number,
            neighborhood = contactResponse.address.neighborhood,
            complement = contactResponse.address.complement
        )
}
