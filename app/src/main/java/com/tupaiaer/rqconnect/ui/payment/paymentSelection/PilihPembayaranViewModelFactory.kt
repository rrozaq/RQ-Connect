package com.tupaiaer.rqconnect.ui.payment.paymentSelection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tupaiaer.rqconnect.data.repositories.ChosePaymentRepository

@Suppress("UNCHECKED_CAST")
class PilihPembayaranViewModelFactory(
    private val repository: ChosePaymentRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PilihPembayaranViewModel(
            repository
        ) as T
    }
}