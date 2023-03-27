package com.jsbl.sara.funds

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jsbl.sara.R


class FundsWithdrawHistoryActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fund_withdraw_history)
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

        var recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        var myViewHolderAdapter: RecyclerView.Adapter<MyViewHolder> =
            object : RecyclerView.Adapter<MyViewHolder>() {
                override fun onCreateViewHolder(
                    viewGroup: ViewGroup,
                    ViewType: Int,
                ): MyViewHolder {
                    return MyViewHolder(LayoutInflater.from(viewGroup.context)
                        .inflate(R.layout.blueprint_fund_deposit_history, viewGroup, false))
                }

                @SuppressLint("DefaultLocale", "SetTextI18n", "NotifyDataSetChanged",
                    "UseCompatLoadingForDrawables")
                override fun onBindViewHolder(
                    viewHolderRt: MyViewHolder,
                    i: Int,
                ) {
                        viewHolderRt.transactionType.text = "Debit"

                        if(i==0){
                            viewHolderRt.status.text = "Success"
                            viewHolderRt.status.setTextColor(resources.getColor(R.color.green))
                            viewHolderRt.statusIcon.setImageResource(R.drawable.done)
                        }else if(i == 1){
                            viewHolderRt.status.text = "Failed"
                            viewHolderRt.status.setTextColor(resources.getColor(R.color.amber))
                            viewHolderRt.statusIcon.setImageResource(R.drawable.canceled)
                            viewHolderRt.lyTransactionId.visibility = View.GONE
                        }else{
                            viewHolderRt.lyTransactionId.visibility = View.GONE
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
        var lyTransactionId: LinearLayout = itemView.findViewById(R.id.ly_transactions)
        var transactionType: TextView = itemView.findViewById(R.id.transaction_type)
        var status: TextView = itemView.findViewById(R.id.status)
        var statusIcon: ImageView = itemView.findViewById(R.id.status_icon)
    }
}