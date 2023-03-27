package com.jsbl.sara.my_bids

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.jsbl.sara.*
import com.jsbl.sara.funds.FundsActivity
import com.google.android.material.navigation.NavigationView
import com.jsbl.sara.views.activities.*


class MyBidsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_bids)

        setDrawer()

        findViewById<ImageView>(R.id.home).setOnClickListener {
            finish()
            startActivity(Intent(this@MyBidsActivity, DashboardActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.passbook_bottom_nav).setOnClickListener {
            startActivity(Intent(this@MyBidsActivity, PassbookActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.funds_bottom_nav).setOnClickListener {
            startActivity(Intent(this@MyBidsActivity, FundsActivity::class.java))
        }

        findViewById<CardView>(R.id.bid_history).setOnClickListener {
            startActivity(Intent(this@MyBidsActivity, BidHistoryActivity::class.java))
        }

        findViewById<CardView>(R.id.game_results).setOnClickListener {
            startActivity(Intent(this@MyBidsActivity, GameResultsActivity::class.java))
        }

        findViewById<CardView>(R.id.king_starline_bid_history).setOnClickListener {
            startActivity(Intent(this@MyBidsActivity, StarlineBidHistoryActivity::class.java))
        }

        findViewById<CardView>(R.id.king_starline_result_history).setOnClickListener {
            startActivity(Intent(this@MyBidsActivity, KingStarlineResultsActivity::class.java))
        }

        findViewById<CardView>(R.id.king_jackpot_bid_history).setOnClickListener {
            startActivity(Intent(this@MyBidsActivity, KingJackpotBidHistoryActivity::class.java))
        }

        findViewById<CardView>(R.id.king_jackpot_result_history).setOnClickListener {
            startActivity(Intent(this@MyBidsActivity, KingJackpotResultsActivity::class.java))
        }

    }

    private fun setDrawer() {
        var drawer = findViewById<DrawerLayout>(R.id.drawer)

        findViewById<ImageView>(R.id.menu).setOnClickListener {
            drawer.openDrawer(
                GravityCompat.START)
        }

        var navigation = findViewById<NavigationView>(R.id.navigation)

          navigation.findViewById<View>(R.id.home_nav).setOnClickListener {
            // code for navigation to home screen here
        }

        navigation.findViewById<View>(R.id.ll_game_rates).setOnClickListener {
            startActivity(Intent(this, GamesRatesActivity::class.java))
        }

        navigation.findViewById<View>(R.id.settings_nav).setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        navigation.findViewById<View>(R.id.notification).setOnClickListener {
            startActivity(Intent(this, NotificationActivity::class.java))
        }  
        
        navigation.findViewById<View>(R.id.notice).setOnClickListener {
            startActivity(Intent(this, NoticeBoardActivity::class.java))
        }  
        
        navigation.findViewById<View>(R.id.mpin_nav).setOnClickListener {
            startActivity(Intent(this, MpinActivity::class.java))
        }

        navigation.findViewById<View>(R.id.invite_and_earn).setOnClickListener {
            startActivity(Intent(this, InviteAndEarnActivity::class.java))
        }

    }


}