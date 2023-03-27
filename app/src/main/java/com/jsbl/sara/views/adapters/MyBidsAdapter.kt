package com.jsbl.sara.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jsbl.sara.Models.MyBidsResponse
import com.jsbl.sara.R
import com.jsbl.sara.databinding.ItemsFundBinding

class MyBidsAdapter (
    private var itemsList: MutableList<MyBidsResponse>) :
    RecyclerView.Adapter<MyBidsAdapter.MyBidsListingViewHolder>() {


    var onItemClick: ((MyBidsResponse) -> Unit)? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyBidsListingViewHolder {
        val mBinding = DataBindingUtil.inflate<ItemsFundBinding>(
            LayoutInflater.from(parent.context),
            R.layout.items_fund,
            parent, false
        )
        return MyBidsListingViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: MyBidsListingViewHolder, position: Int) {
        holder.onBind(itemsList[position], onItemClick)

    }

    override fun getItemCount() = itemsList.size

    fun addItem(item: MyBidsResponse) {
        itemsList.add(item)
        val size: Int = itemsList.size
        notifyItemInserted(size - 1)
    }

    inner class MyBidsListingViewHolder
    constructor(private val binding: ItemsFundBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun onBind(info: MyBidsResponse, itemClickListener: ((MyBidsResponse) -> Unit)?) {
            binding.executePendingBindings()

            binding.header.text = info.funds_action
            binding.description.text = info.description


        }
    }

    fun updateList(itemList: ArrayList<MyBidsResponse>) {
        this.itemsList = itemList
        notifyDataSetChanged()

    }

}