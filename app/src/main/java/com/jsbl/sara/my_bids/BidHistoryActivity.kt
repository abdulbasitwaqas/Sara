package com.jsbl.sara.my_bids

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jsbl.sara.R
import java.util.ArrayList

class BidHistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bid_history)

        findViewById<ImageView>(R.id.back).setOnClickListener {
            onBackPressed()
        }

        setRecyclerView()
    }

    private fun setRecyclerView() {

        var dummyList = ArrayList<String>()

        dummyList.add("1")
        dummyList.add("1")
        dummyList.add("1")
        dummyList.add("1")
        dummyList.add("1")
        dummyList.add("1")
        dummyList.add("1")
        dummyList.add("1")
        dummyList.add("1")
        dummyList.add("1")
        dummyList.add("1")
        dummyList.add("1")
        dummyList.add("1")
        dummyList.add("1")
        dummyList.add("1")
        dummyList.add("1")
        dummyList.add("1")
        dummyList.add("1")
        dummyList.add("1")
        dummyList.add("1")
        dummyList.add("1")
        dummyList.add("1")
        dummyList.add("1")
        dummyList.add("1")

        var recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        var myViewHolderAdapter: RecyclerView.Adapter<MyViewHolder> = object : RecyclerView.Adapter<MyViewHolder>() {
            override fun onCreateViewHolder(
                viewGroup: ViewGroup,
                ViewType: Int,
            ): MyViewHolder {
                return MyViewHolder(LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.blueprint_bid_history, viewGroup, false))
            }

            @SuppressLint("DefaultLocale", "SetTextI18n", "NotifyDataSetChanged",
                "UseCompatLoadingForDrawables")
            override fun onBindViewHolder(
                viewHolderRt: MyViewHolder,
                i: Int,
            ) {
                if(i%2 == 0){
                    viewHolderRt.status.text = "Congratulations. You Won (9) "
                    viewHolderRt.status.setTextColor(resources.getColor(R.color.green))
                    viewHolderRt.thumb.setImageResource(R.drawable.thumb_up_new)
                }else{

                }
            }

            override fun getItemCount(): Int {

                return dummyList.size
            }
        }

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = myViewHolderAdapter
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var root: CardView = itemView.findViewById(R.id.bid_history_item)
        var status: TextView = itemView.findViewById(R.id.status)
        var thumb: ImageView = itemView.findViewById(R.id.iv_thumb)
    }
}