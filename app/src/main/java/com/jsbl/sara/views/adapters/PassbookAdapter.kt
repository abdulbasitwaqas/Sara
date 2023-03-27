package com.jsbl.sara.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jsbl.sara.Models.PassbookResponse
import com.jsbl.sara.R
import com.jsbl.sara.databinding.BlueprintPassbookItemsBinding

class PassbookAdapter (
    private var itemsList: MutableList<PassbookResponse>) :
    RecyclerView.Adapter<PassbookAdapter.PassbookListingViewHolder>() {


    var onItemClick: ((PassbookResponse) -> Unit)? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PassbookListingViewHolder {
        val mBinding = DataBindingUtil.inflate<BlueprintPassbookItemsBinding>(
            LayoutInflater.from(parent.context),
            R.layout.blueprint_passbook_items,
            parent, false
        )
        return PassbookListingViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: PassbookListingViewHolder, position: Int) {
        holder.onBind(itemsList[position], onItemClick)

    }

    override fun getItemCount() = itemsList.size

    fun addItem(item: PassbookResponse) {
        itemsList.add(item)
        val size: Int = itemsList.size
        notifyItemInserted(size - 1)
    }

    inner class PassbookListingViewHolder
    constructor(private val binding: BlueprintPassbookItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun onBind(info: PassbookResponse, itemClickListener: ((PassbookResponse) -> Unit)?) {
            binding.executePendingBindings()
            


        }
    }

    fun updateList(itemList: ArrayList<PassbookResponse>) {
        this.itemsList = itemList
        notifyDataSetChanged()

    }

}