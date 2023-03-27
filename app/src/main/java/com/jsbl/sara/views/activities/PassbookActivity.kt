package com.jsbl.sara.views.activities

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
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jsbl.sara.R


class PassbookActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passbook)
        findViewById<ImageView>(R.id.back).setOnClickListener {
            onBackPressed()
        }
        var display1 = (getSystemService(WINDOW_SERVICE) as WindowManager).defaultDisplay
        val orientation = display1.orientation

        findViewById<ImageView>(R.id.rotate).setOnClickListener {
            Log.d("mylog", "onCreate: ${orientation}")
            requestedOrientation = if(orientation == Configuration.ORIENTATION_PORTRAIT){
                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            }else{
                ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            }
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

        var myViewHolderAdapter: RecyclerView.Adapter<MyViewHolder> =
            object : RecyclerView.Adapter<MyViewHolder>() {
                override fun onCreateViewHolder(
                    viewGroup: ViewGroup,
                    ViewType: Int,
                ): MyViewHolder {
                    return MyViewHolder(LayoutInflater.from(viewGroup.context)
                        .inflate(R.layout.blueprint_passbook_items, viewGroup, false))
                }

                @SuppressLint("DefaultLocale", "SetTextI18n", "NotifyDataSetChanged",
                    "UseCompatLoadingForDrawables")
                override fun onBindViewHolder(
                    viewHolderRt: MyViewHolder,
                    i: Int,
                ) {

                }

                override fun getItemCount(): Int {

                    return dummyList.size
                }
            }

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = myViewHolderAdapter
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var transactionDate: TextView = itemView.findViewById(R.id.transaction_date)
    }
}