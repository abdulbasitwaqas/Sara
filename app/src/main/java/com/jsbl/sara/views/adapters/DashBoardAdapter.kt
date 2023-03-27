package com.jsbl.sara.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jsbl.sara.Models.DashboardResponse
import com.jsbl.sara.R
import com.jsbl.sara.databinding.BlueprintHomeScreenItemsBinding

class DashBoardAdapter (
    private var itemsList: MutableList<DashboardResponse>) :
    RecyclerView.Adapter<DashBoardAdapter.DashBoardListingViewHolder>() {


    var onItemClick: ((DashboardResponse) -> Unit)? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashBoardListingViewHolder {
        val mBinding = DataBindingUtil.inflate<BlueprintHomeScreenItemsBinding>(
            LayoutInflater.from(parent.context),
            R.layout.blueprint_home_screen_items,
            parent, false
        )
        return DashBoardListingViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: DashBoardListingViewHolder, position: Int) {
        holder.onBind(itemsList[position], onItemClick)

    }

    override fun getItemCount() = itemsList.size

    fun addItem(item: DashboardResponse) {
        itemsList.add(item)
        val size: Int = itemsList.size
        notifyItemInserted(size - 1)
    }

    inner class DashBoardListingViewHolder
    constructor(private val binding: BlueprintHomeScreenItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun onBind(info: DashboardResponse, itemClickListener: ((DashboardResponse) -> Unit)?) {
            binding.executePendingBindings()

            binding.title.text = info.headerName
            binding.number.text = info.bid_number
            binding.tvOpenBidTime.text = info.open_bid_time
            binding.tvCloseBidTime.text = info.close_bid_time
            binding.tvBidStatus.text = info.status


        }
    }

    fun updateList(itemList: ArrayList<DashboardResponse>) {
        this.itemsList = itemList
        notifyDataSetChanged()

    }

}