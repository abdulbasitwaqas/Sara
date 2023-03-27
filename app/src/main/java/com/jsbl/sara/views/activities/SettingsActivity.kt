package com.jsbl.sara.views.activities

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.jsbl.sara.funds.FundsActivity
import com.google.android.material.navigation.NavigationView
import com.jsbl.sara.*


class SettingsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        setDrawer()

        findViewById<ImageView>(R.id.home).setOnClickListener {
            finish()
            startActivity(Intent(this@SettingsActivity, DashboardActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.passbook_bottom_nav).setOnClickListener {
            startActivity(Intent(this@SettingsActivity, PassbookActivity::class.java))
        }


        findViewById<LinearLayout>(R.id.funds_bottom_nav).setOnClickListener {
            startActivity(Intent(this, FundsActivity::class.java))
        }

        findViewById<Button>(R.id.btn1).setOnClickListener {
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.something_went_wrong_dialog_box)

            dialog.findViewById<Button>(R.id.yes_dialog_box)
                .setOnClickListener { dialog.cancel() }

            dialog.show()
        }

        findViewById<Button>(R.id.btn).setOnClickListener {
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.session_expired_dialog_box)
            dialog.window!!.setBackgroundDrawableResource(R.drawable.white_round)
            dialog.window!!.attributes.dimAmount = 0.8f
            dialog.window!!.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)

            dialog.findViewById<Button>(R.id.yes_dialog_box)
                .setOnClickListener { dialog.cancel() }
            dialog.show()
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