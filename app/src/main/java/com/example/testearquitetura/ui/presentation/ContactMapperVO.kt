package com.example.testearquitetura.ui.presentation

import android.content.res.Resources
import com.example.testearquitetura.R
import com.example.testearquitetura.domain.Contact
import com.example.testearquitetura.ui.model.ContactVO

class ContactMapperVO constructor(val resources : Resources) {

    fun contactBoToVO(contactBO: Contact) : ContactVO {
        var hasEmail = contactBO.email.isNotEmpty()
        var hasPhone = contactBO.phone.isNotEmpty()
        var textBtnEmail: String
        var textBtnPhone: String
        var textEmail: String
        var textPhone: String

        if (hasEmail) {
            textBtnEmail = resources.getString(R.string.edit_enmail)
            textEmail = contactBO.email
        } else {
            textBtnEmail = resources.getString(R.string.add_email)
            textEmail = resources.getString(R.string.email_empty)
        }

        if (hasPhone) {
            textBtnPhone = resources.getString(R.string.edit_phone)
            textPhone = contactBO.phone
        } else {
            textBtnPhone = resources.getString(R.string.add_phone)
            textPhone = resources.getString(R.string.phone_empty)

        }

        return ContactVO(
            firstName = contactBO.name,
            age = contactBO.age,
            email = textEmail,
            textBtnEmail = textBtnEmail,
            textBtnPhone = textBtnPhone,
            phone = textPhone,
            enableContinueButton = hasEmail && hasPhone
        )
    }
}