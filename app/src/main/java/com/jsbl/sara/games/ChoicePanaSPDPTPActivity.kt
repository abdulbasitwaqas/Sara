package com.jsbl.sara.games

import android.annotation.SuppressLint
import android.app.Dialog
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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jsbl.sara.R
import org.w3c.dom.Text

class ChoicePanaSPDPTPActivity : AppCompatActivity() {

    private lateinit  var bottomView: LinearLayout 
private lateinit  var bottomView2: LinearLayout

    lateinit var myViewHolderAdapter: RecyclerView.Adapter<MyViewHolder>
    private lateinit var recyclerView: RecyclerView
    private var dummyList = ArrayList<String>()
    
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice_pana_sp_dp_tp)

        findViewById<ImageView>(R.id.back).setOnClickListener {
            onBackPressed()
        }
        
        val tv = findViewById<TextView>(R.id.header_text)
        tv.isSelected = true

        val tv2 = findViewById<TextView>(R.id.game_type)
        tv2.isSelected = true

        tv2.setOnClickListener {
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.window!!.setBackgroundDrawableResource(R.drawable.white_round)
            dialog.setContentView(R.layout.change_game_dialog_box)

            dialog.findViewById<ImageView>(R.id.cross)
                .setOnClickListener { dialog.cancel() }

            dialog.findViewById<TextView>(R.id.open)
                .setOnClickListener { dialog.cancel() }

            dialog.findViewById<TextView>(R.id.close)
                .setOnClickListener { dialog.cancel() }
            dialog.show()
        }

        bottomView = findViewById(R.id.bottom_view_game)
        bottomView2 = findViewById(R.id.line)

        findViewById<Button>(R.id.add).setOnClickListener {
            dummyList.add("1")
            recyclerView.adapter!!.notifyDataSetChanged()
            checkIsListEmpty()

            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.window!!.setBackgroundDrawableResource(R.drawable.white_round)
            dialog.setContentView(R.layout.bid_added_dialog_box)
            
            dialog.findViewById<TextView>(R.id.yes_dialog_box)
                .setOnClickListener { dialog.cancel() }
            
            dialog.show()

            
        }

        checkIsListEmpty()
        setRecyclerView()
        
    }

    private fun checkIsListEmpty() {
        if(dummyList.isEmpty()){
            bottomView.visibility = View.GONE
            bottomView2.visibility = View.GONE
        }else{
            bottomView.visibility = View.VISIBLE
            bottomView2.visibility = View.VISIBLE
        }
    }

    private fun setRecyclerView() {
        
        recyclerView = findViewById(R.id.recyclerView)
        myViewHolderAdapter = object : RecyclerView.Adapter<MyViewHolder>() {
            override fun onCreateViewHolder(
                viewGroup: ViewGroup,
                ViewType: Int,
            ): MyViewHolder {
                return MyViewHolder(LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.blueprint_game_screen_items, viewGroup, false))
            }

            @SuppressLint("DefaultLocale", "SetTextI18n", "NotifyDataSetChanged",
                "UseCompatLoadingForDrawables")
            override fun onBindViewHolder(
                viewHolderRt: MyViewHolder,
                i: Int,
            ) {

                viewHolderRt.type.text = "Open"
                viewHolderRt.type.setTextColor(resources.getColor(R.color.green))
                viewHolderRt.delete.setOnClickListener {
                    dummyList.removeAt(i)
                    recyclerView.adapter!!.notifyDataSetChanged()
                    checkIsListEmpty()
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
        var delete: ImageView = itemView.findViewById(R.id.delete)
        var type: TextView = itemView.findViewById(R.id.type)
    }
}