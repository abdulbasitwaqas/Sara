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

class SingleDigitsBulkActivity : AppCompatActivity() {
    
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_digit_bulk)

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


    }

}