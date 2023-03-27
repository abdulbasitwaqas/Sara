package com.jsbl.sara.views.activities

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jsbl.sara.R
import com.jsbl.sara.funds.FundsWithdrawHistoryActivity
import com.jsbl.sara.games.SPDPTPActivity

class KingStarlineDashboardActivity : AppCompatActivity() {

    lateinit var myViewHolderAdapter: RecyclerView.Adapter<MyViewHolder>
    private lateinit var recyclerView: RecyclerView
    private var dummyList = ArrayList<String>()
    
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_king_starline_dashboard)
        findViewById<ImageView>(R.id.back).setOnClickListener {
            onBackPressed()
        }

        findViewById<LinearLayout>(R.id.history).setOnClickListener {
            startActivity(Intent(this, KingStarlineHistoryActivity::class.java))

        }

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
        setRecyclerView()
    }

    private fun setRecyclerView() {

        recyclerView = findViewById(R.id.recyclerView)
        myViewHolderAdapter = object : RecyclerView.Adapter<MyViewHolder>() {
            override fun onCreateViewHolder(
                viewGroup: ViewGroup,
                ViewType: Int,
            ): MyViewHolder {
                return MyViewHolder(LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.blueprint_king_starline_items, viewGroup, false))
            }

            @SuppressLint("DefaultLocale", "SetTextI18n", "NotifyDataSetChanged",
                "UseCompatLoadingForDrawables")
            override fun onBindViewHolder(
                viewHolderRt: MyViewHolder,
                i: Int,
            ) {

                viewHolderRt.root.setOnClickListener {
                    val dialog = Dialog(this@KingStarlineDashboardActivity)
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                    dialog.setCancelable(false)
                    dialog.window!!.setBackgroundDrawableResource(R.drawable.white_round)
                    dialog.setContentView(R.layout.bid_closed_for_today_starline_dialog_box)

                    dialog.findViewById<Button>(R.id.ok_dialog_box)
                        .setOnClickListener { dialog.cancel() }
                    dialog.show()
                }
                if(i>2){
                    viewHolderRt.status.text = "Running now"
                    viewHolderRt.status.setTextColor(resources.getColor(R.color.green))
                    viewHolderRt.alarm.setImageResource(R.drawable.alarm_on)
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
        var root: CardView = itemView.findViewById(R.id.root)
        var alarm: ImageView = itemView.findViewById(R.id.alarm)
        var status: TextView = itemView.findViewById(R.id.status)
    }
}