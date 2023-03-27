package com.jsbl.sara.my_bids

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jsbl.sara.R
import java.util.*

class KingStarlineResultsActivity : AppCompatActivity() {

    private lateinit var textViewDate : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_king_starline_results)

        val tv = findViewById<TextView>(R.id.header_text)
        tv.isSelected = true

        textViewDate = findViewById(R.id.calendar_text)

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        findViewById<ImageView>(R.id.back).setOnClickListener {
           onBackPressed()
        }

        findViewById<LinearLayout>(R.id.calendar_text_ly).setOnClickListener {
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->

                textViewDate.text = " $dayOfMonth/${monthOfYear+1}/$year"

            }, year, month, day)

            dpd.show()
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
                    .inflate(R.layout.blueprint_game_results, viewGroup, false))
            }

            @SuppressLint("DefaultLocale", "SetTextI18n", "NotifyDataSetChanged",
                "UseCompatLoadingForDrawables")
            override fun onBindViewHolder(
                viewHolderRt: MyViewHolder,
                i: Int,
            ) {
                viewHolderRt.title.text = "10:30 AM"
                viewHolderRt.number.text = "136-0"
            }

            override fun getItemCount(): Int {

                return dummyList.size
            }
        }

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = myViewHolderAdapter
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var root: CardView = itemView.findViewById(R.id.game_result_item)
        var title: TextView = itemView.findViewById(R.id.title)
        var number: TextView = itemView.findViewById(R.id.number)
    }
}