package br.com.uol.domain.usecase

import br.com.uol.data.CustomerRepository
import br.com.uol.domain.Customer

class CustomerDataUseCase(
    private val repository: CustomerRepository
) {
    suspend fun execute(): List<Customer> {
        return repository.getListCustomer()
    }
}