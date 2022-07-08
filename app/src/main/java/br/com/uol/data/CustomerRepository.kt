package br.com.uol.data

import br.com.uol.domain.Customer

interface CustomerRepository {
    suspend fun getListCustomer(): List<Customer>
}