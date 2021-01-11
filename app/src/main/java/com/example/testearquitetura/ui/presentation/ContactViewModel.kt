package com.example.testearquitetura.ui.presentation

import androidx.lifecycle.MutableLiveData
import com.example.testearquitetura.domain.ContactRepository
import com.example.testearquitetura.ui.model.ContactVO
import io.reactivex.android.schedulers.AndroidSchedulers

class ContactViewModel(private val repository: ContactRepository,
                       private val contactMapperVO: ContactMapperVO
):  BaseViewModel() {

    val contactLiveData = MutableLiveData<ContactState>()

    fun fetchContact() {
        disposables.add(
            repository.fetchContact().observeOn(
                AndroidSchedulers.mainThread()
            ).doOnSubscribe {
                contactLiveData.value =
                    ContactState.Loading
            }.subscribe(
                {
                    if (it != null) {
                        contactLiveData.value =
                            ContactState.Success(
                                contactMapperVO.contactBoToVO(it)
                            )
                    } else {
                        contactLiveData.value =
                            ContactState.EmptyContact
                    }
                },
                {
                    contactLiveData.value =
                        ContactState.Error(
                            it.message
                        )
                }
            )
        )
    }

    sealed class ContactState {

        class Success(val data: ContactVO) : ContactState()

        class Error(val message: String?) : ContactState()

        object Loading : ContactState()

        object EmptyContact : ContactState()
    }
}