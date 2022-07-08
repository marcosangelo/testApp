package br.com.uol.di

import CustomerService
import br.com.uol.data.CustomerRepository
import br.com.uol.data.CustomerRepositoryImpl
import br.com.uol.domain.usecase.CustomerDataUseCase
import br.com.uol.view.customers.CustomerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

object CustomerModules {

    val module = module {
        viewModel { CustomerViewModel(get()) }
        single { CustomerDataUseCase(get()) }
        single<CustomerRepository> {
            CustomerRepositoryImpl(provideCustomerService(get()))
        }
    }

    private fun provideCustomerService(retrofit: Retrofit) =
        retrofit.create(CustomerService::class.java)
}