package com.jsbl.sara.views.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.jsbl.sara.R
import com.jsbl.sara.games.*

class SelectGameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_game)

        val tv = findViewById<TextView>(R.id.header_text)
        tv.isSelected = true

        findViewById<ImageView>(R.id.back).setOnClickListener {
            onBackPressed()
        }

        findViewById<LinearLayout>(R.id.single_digit).setOnClickListener {
            startActivity(Intent(this@SelectGameActivity, SingleDigitActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.single_digit_bulk).setOnClickListener {
            startActivity(Intent(this@SelectGameActivity, SingleDigitsBulkActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.jodi_digits).setOnClickListener {
            startActivity(Intent(this@SelectGameActivity, JodiDigitsActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.jodi_digits_bulk).setOnClickListener {
            startActivity(Intent(this@SelectGameActivity, JodiDigitsBulkActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.single_pana_bulk).setOnClickListener {
            startActivity(Intent(this@SelectGameActivity, SinglePanaBulkActivity::class.java))
        }
        findViewById<LinearLayout>(R.id.double_pana_bulk).setOnClickListener {
            startActivity(Intent(this@SelectGameActivity, DoublePanaBulkActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.single_pana).setOnClickListener {
            startActivity(Intent(this@SelectGameActivity, SinglePanaActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.double_pana).setOnClickListener {
            startActivity(Intent(this@SelectGameActivity, DoublePanaActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.triple_pana).setOnClickListener {
            startActivity(Intent(this@SelectGameActivity, TriplePanaActivity::class.java))
        }

//        findViewById<LinearLayout>(R.id.panel_group).setOnClickListener {
//            startActivity(Intent(this@SelectGameActivity, PanelGroupActivity::class.java))
//        }
//
//        findViewById<LinearLayout>(R.id.red_brackets_board).setOnClickListener {
//            startActivity(Intent(this@SelectGameActivity, RedBracketsActivity::class.java))
//        }
//
//        findViewById<LinearLayout>(R.id.sp_dp_tp_board).setOnClickListener {
//            startActivity(Intent(this@SelectGameActivity, SPDPTPActivity::class.java))
//        }
//
//        findViewById<LinearLayout>(R.id.choice_sp_dp_tp_board).setOnClickListener {
//            startActivity(Intent(this@SelectGameActivity, ChoicePanaSPDPTPActivity::class.java))
//        }
//
//        findViewById<LinearLayout>(R.id.sp_motor_board).setOnClickListener {
//            startActivity(Intent(this@SelectGameActivity, SpMotorActivity::class.java))
//        }
//
//        findViewById<LinearLayout>(R.id.dp_board).setOnClickListener {
//            startActivity(Intent(this@SelectGameActivity, DpMotorActivity::class.java))
//        }
//
//        findViewById<LinearLayout>(R.id.group_jodi_board).setOnClickListener {
//            startActivity(Intent(this@SelectGameActivity, GroupJodiActivity::class.java))
//        }
//
//        findViewById<LinearLayout>(R.id.digits_based_jodi_board).setOnClickListener {
//            startActivity(Intent(this@SelectGameActivity, DigitsBasedActivity::class.java))
//        }
//
//        findViewById<LinearLayout>(R.id.odd_even_board).setOnClickListener {
//            startActivity(Intent(this@SelectGameActivity, OddEvenActivity::class.java))
//        }
//
//        findViewById<LinearLayout>(R.id.two_digits_panel_board).setOnClickListener {
//            startActivity(Intent(this@SelectGameActivity, TwoDigitPanelActivity::class.java))
//        }

        findViewById<LinearLayout>(R.id.half_sangam_a_board).setOnClickListener {
            startActivity(Intent(this@SelectGameActivity, HalfSangamAActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.half_sangam_b_board).setOnClickListener {
            startActivity(Intent(this@SelectGameActivity, HalfSangamBActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.full_sangam_board).setOnClickListener {
            startActivity(Intent(this@SelectGameActivity, FullSangamActivity::class.java))
        }
    }
}