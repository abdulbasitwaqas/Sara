package com.jsbl.sara.funds

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.jsbl.sara.*
import com.jsbl.sara.my_bids.MyBidsActivity
import com.google.android.material.navigation.NavigationView
import com.jsbl.sara.views.activities.*


class FundsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_funds)

        setDrawer()

        findViewById<ImageView>(R.id.home).setOnClickListener {
            finish()
            startActivity(Intent(this@FundsActivity, DashboardActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.passbook_bottom_nav).setOnClickListener {
            startActivity(Intent(this@FundsActivity, PassbookActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.my_bids_bottom_nav).setOnClickListener {
            startActivity(Intent(this@FundsActivity, MyBidsActivity::class.java))
        }

        findViewById<CardView>(R.id.add_fund).setOnClickListener {
            startActivity(Intent(this@FundsActivity, AddFundActivity::class.java))
        }

        findViewById<CardView>(R.id.withdraw_fund).setOnClickListener {
            startActivity(Intent(this@FundsActivity, WithdrawFundActivity::class.java))
        }

        findViewById<CardView>(R.id.add_bank_details).setOnClickListener {
            startActivity(Intent(this@FundsActivity, AddBankActivity::class.java))
        }

        findViewById<CardView>(R.id.add_upi_details).setOnClickListener {
            startActivity(Intent(this@FundsActivity, AddUPIActivity::class.java))
        }

        findViewById<CardView>(R.id.fund_deposit).setOnClickListener {
            startActivity(Intent(this@FundsActivity, FundsDepositHistoryActivity::class.java))
        }
        
        findViewById<CardView>(R.id.fund_withdraw_history).setOnClickListener {
            startActivity(Intent(this@FundsActivity, FundsWithdrawHistoryActivity::class.java))
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
            startActivity(Intent(this@FundsActivity, GamesRatesActivity::class.java))
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