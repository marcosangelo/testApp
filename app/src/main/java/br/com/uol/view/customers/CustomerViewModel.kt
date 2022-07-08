package br.com.uol.view.customers

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.uol.domain.Customer
import br.com.uol.domain.usecase.CustomerDataUseCase
import kotlinx.coroutines.launch

class CustomerViewModel(private val customerDataUseCase: CustomerDataUseCase) : ViewModel(),
    DefaultLifecycleObserver {

    private val _listCustomer = MutableLiveData<List<Customer>>()
    val listCustomer: LiveData<List<Customer>> = _listCustomer

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        loadCustomers()
    }

    fun loadCustomers() = viewModelScope.launch {
        val customers = customerDataUseCase.execute()
        _listCustomer.postValue(customers)
    }
}