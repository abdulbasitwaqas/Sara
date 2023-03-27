package com.jsbl.sara.views.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.jsbl.sara.funds.FundsActivity
import com.google.android.material.navigation.NavigationView
import com.jsbl.sara.R
import com.jsbl.sara.views.activities.SettingsActivity
import kotlinx.android.synthetic.main.activity_game_rates.*


class GamesRatesActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_rates)

        iv_back_game_rates.setOnClickListener {
            finish()
        }

    }

/*    private fun setDrawer() {
        var drawer = findViewById<DrawerLayout>(R.id.drawer)

        findViewById<ImageView>(R.id.menu).setOnClickListener {
            drawer.openDrawer(
                GravityCompat.START)
        }

        var navigation = findViewById<NavigationView>(R.id.navigation)

          navigation.findViewById<View>(R.id.home_nav).setOnClickListener {
            // code for navigation to home screen here
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


    }*/


}