package br.com.uol.data

import CustomerService
import br.com.uol.domain.Customer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CustomerRepositoryImpl(
    private val service: CustomerService
) : CustomerRepository {

    override suspend fun getListCustomer(): List<Customer> = withContext(Dispatchers.IO) {
        try {
            val callback = service.getCustomers()
            callback.customers
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}