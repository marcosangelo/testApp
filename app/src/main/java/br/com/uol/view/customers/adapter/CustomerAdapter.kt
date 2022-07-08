package br.com.uol.view.customers.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.uol.R
import br.com.uol.databinding.ItemCustomerAdapterBinding
import br.com.uol.domain.Customer
import br.com.uol.view.customers.CustomerViewModel

class CustomerAdapter(
    private val viewModel: CustomerViewModel
) : ListAdapter<Customer, CustomerAdapter.DataHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        return DataHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_customer_adapter,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        holder.binding.customer = getItem(position)
        holder.binding.viewModel = viewModel
    }

    inner class DataHolder(val binding: ItemCustomerAdapterBinding) :
        RecyclerView.ViewHolder(binding.root)

    private object DiffCallback : DiffUtil.ItemCallback<Customer>() {
        override fun areItemsTheSame(
            oldItem: Customer,
            newItem: Customer
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: Customer,
            newItem: Customer
        ) = oldItem == newItem
    }
}