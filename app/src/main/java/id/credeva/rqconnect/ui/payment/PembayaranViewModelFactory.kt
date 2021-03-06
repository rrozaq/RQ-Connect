package id.credeva.rqconnect.ui.payment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.credeva.rqconnect.data.repositories.LatePaymentRepository
import id.credeva.rqconnect.data.repositories.PaidOffPaymentRepository
import id.credeva.rqconnect.data.repositories.RemainPaymentRepository

@Suppress("UNCHECKED_CAST")
class PembayaranViewModelFactory(
    private val latePaymentRepository: LatePaymentRepository,
    private val remainPaymentRepository: RemainPaymentRepository,
    private val paidOffPaymentRepository: PaidOffPaymentRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PembayaranViewModel(latePaymentRepository, remainPaymentRepository, paidOffPaymentRepository) as T
    }
}