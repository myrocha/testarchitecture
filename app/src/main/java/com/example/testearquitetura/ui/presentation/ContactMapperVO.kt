package com.example.testearquitetura.ui.presentation

import com.example.testearquitetura.domain.Contact
import com.example.testearquitetura.ui.model.ContactVO

class ContactMapperVO {

    fun contactBoToVO(contactBO: Contact) : ContactVO {
        val hasEmail = contactBO.email.isNotEmpty()
        val hasPhone = contactBO.phone.isNotEmpty()
        return ContactVO(
            firstName = contactBO.name,
            age = contactBO.age,
            email = contactBO.email,
            hasEmail = hasEmail,
            phone = contactBO.phone,
            hasPhone = hasPhone,
            enableContinueButton = hasEmail && hasPhone
        )
    }
}