package com.jsbl.sara.funds

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.jsbl.sara.*
import com.jsbl.sara.my_bids.MyBidsActivity
import com.google.android.material.navigation.NavigationView
import com.jsbl.sara.views.activities.*


class AddFundActivity : AppCompatActivity() {


    var a = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_fund)

        setDrawer()

        findViewById<ImageView>(R.id.home).setOnClickListener {
            startActivity(Intent(this@AddFundActivity, DashboardActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.passbook_bottom_nav).setOnClickListener {
            startActivity(Intent(this@AddFundActivity, PassbookActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.my_bids_bottom_nav).setOnClickListener {
            startActivity(Intent(this@AddFundActivity, MyBidsActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.funds_bottom_nav).setOnClickListener {
            onBackPressed()
        }
        findViewById<Button>(R.id.btn_add_cash).setOnClickListener {
            if(a==1){
                val dialog = Dialog(this)
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                dialog.setCancelable(false)
                dialog.window!!.setBackgroundDrawableResource(R.drawable.white_round)
                dialog.setContentView(R.layout.payment_added_dialog_box)

                dialog.findViewById<Button>(R.id.yes_dialog_box)
                    .setOnClickListener { dialog.cancel() }
                dialog.show()
                a = 0
            }else{
                val dialog = Dialog(this)
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                dialog.setCancelable(false)
                dialog.window!!.setBackgroundDrawableResource(R.drawable.white_round)
                dialog.setContentView(R.layout.payment_canceled_dialog_box)

                dialog.findViewById<Button>(R.id.yes_dialog_box)
                    .setOnClickListener { dialog.cancel() }
                dialog.show()
                a=1
            }

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