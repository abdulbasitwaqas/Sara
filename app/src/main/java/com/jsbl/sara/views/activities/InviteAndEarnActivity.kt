package com.jsbl.sara.views.activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jsbl.sara.R

class InviteAndEarnActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_invite_and_earn)

        findViewById<ImageView>(R.id.back).setOnClickListener {
            onBackPressed()
        }
        setRecyclerView()

    }

    private fun setRecyclerView() {

        var recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        var myViewHolderAdapterBaharHaruf = object : RecyclerView.Adapter<MyViewHolder>() {
            override fun onCreateViewHolder(
                viewGroup: ViewGroup,
                ViewType: Int,
            ): MyViewHolder {
                return MyViewHolder(LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.blueprint_refer_items, viewGroup, false))
            }

            @SuppressLint("DefaultLocale", "SetTextI18n", "NotifyDataSetChanged",
                "UseCompatLoadingForDrawables")
            override fun onBindViewHolder(
                viewHolderRt: MyViewHolder,
                i: Int,
            ) {


            }

            override fun getItemCount(): Int {

                return 10
            }

        }

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = myViewHolderAdapterBaharHaruf
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView = itemView.findViewById(R.id.title)
    }
}