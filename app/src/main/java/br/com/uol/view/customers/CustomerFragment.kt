package br.com.uol.view.customers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.uol.databinding.FragmentCustomerBinding
import br.com.uol.view.customers.adapter.CustomerAdapter
import kotlinx.coroutines.runBlocking
import org.koin.androidx.viewmodel.ext.android.viewModel

class CustomerFragment : Fragment() {

    private lateinit var binding: FragmentCustomerBinding
    private val viewModel: CustomerViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        lifecycle.addObserver(viewModel)
        return FragmentCustomerBinding.inflate(inflater, container, false).also {
            binding = it
            binding.viewModel = viewModel
            binding.lifecycleOwner = viewLifecycleOwner
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() = runBlocking {

        binding.swipeRefresh.setOnRefreshListener {
            viewModel.loadCustomers()
        }

        viewModel.listCustomer.observe(viewLifecycleOwner) {
            val customerAdapter = CustomerAdapter(viewModel = viewModel)
            binding.rvCustomer.apply {
                adapter = customerAdapter
            }
            customerAdapter.submitList(viewModel.listCustomer.value)
            binding.swipeRefresh.isRefreshing = false
        }
    }
}