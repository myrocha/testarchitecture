package com.example.testearquitetura.ui.view

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.example.testearquitetura.R
import com.example.testearquitetura.databinding.ContactViewBinding
import com.example.testearquitetura.ui.model.ContactVO

class ContactView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding: ContactViewBinding

    init {
        inflate(context, R.layout.contact_view, this)
        binding = ContactViewBinding.bind(this)
    }

    fun bind(contactVO: ContactVO) {
        binding.tvName.text = contactVO.firstName

        if (contactVO.hasEmail) {
            binding.tvEmail.text = contactVO.email
            binding.btnAddEmail.text = resources.getString(R.string.edit_enmail)

        } else {
            binding.tvEmail.text = resources.getString(R.string.email_empty)
            binding.btnAddEmail.text = resources.getString(R.string.add_email)
        }

        if (contactVO.hasPhone) {
            binding.tvPhone.text = contactVO.phone
            binding.btnAddPhone.text = resources.getString(R.string.edit_phone)

        } else {
            binding.tvPhone.text = resources.getString(R.string.phone_empty)
            binding.btnAddPhone.text = resources.getString(R.string.add_phone)
        }
        binding.tvAge.text = contactVO.age

        binding.btnIsContinue.isEnabled = contactVO.enableContinueButton

        showViews()
    }


    private fun showViews() {
        binding.tvName.isVisible = true
        binding.tvEmail.isVisible = true
        binding.tvPhone.isVisible = true
        binding.tvAge.isVisible = true
        binding.btnAddEmail.isVisible = true
        binding.btnAddPhone.isVisible = true
        binding.btnIsContinue.isVisible = true
    }
}