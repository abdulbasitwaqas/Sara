package com.jsbl.sara.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jsbl.sara.Models.FundsResponse
import com.jsbl.sara.R
import com.jsbl.sara.databinding.ItemsFundBinding

class FundsAdapter (
    private var itemsList: MutableList<FundsResponse>) :
    RecyclerView.Adapter<FundsAdapter.FundsListingViewHolder>() {


    var onItemClick: ((FundsResponse) -> Unit)? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FundsListingViewHolder {
        val mBinding = DataBindingUtil.inflate<ItemsFundBinding>(
            LayoutInflater.from(parent.context),
            R.layout.items_fund,
            parent, false
        )
        return FundsListingViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: FundsListingViewHolder, position: Int) {
        holder.onBind(itemsList[position], onItemClick)

    }

    override fun getItemCount() = itemsList.size

    fun addItem(item: FundsResponse) {
        itemsList.add(item)
        val size: Int = itemsList.size
        notifyItemInserted(size - 1)
    }

    inner class FundsListingViewHolder
    constructor(private val binding: ItemsFundBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun onBind(info: FundsResponse, itemClickListener: ((FundsResponse) -> Unit)?) {
            binding.executePendingBindings()

            binding.header.text = info.funds_action
            binding.description.text = info.description


        }
    }

    fun updateList(itemList: ArrayList<FundsResponse>) {
        this.itemsList = itemList
        notifyDataSetChanged()

    }

}