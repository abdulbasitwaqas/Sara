package com.jsbl.sara.views.activities

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jsbl.sara.funds.FundsActivity
import com.jsbl.sara.my_bids.MyBidsActivity
import com.google.android.material.navigation.NavigationView
import com.jsbl.sara.R
import com.jsbl.sara.views.activities.SettingsActivity


class NoticeBoardActivity : AppCompatActivity() {

    lateinit var myViewHolderAdapter: RecyclerView.Adapter<MyViewHolder>
    private lateinit var recyclerView: RecyclerView
    private var dummyList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notice_board)

        setDrawer()

        val tv = findViewById<TextView>(R.id.header_text)
        tv.isSelected = true

        findViewById<LinearLayout>(R.id.home_bottom).setOnClickListener {
            finish()
            startActivity(Intent(this@NoticeBoardActivity, DashboardActivity::class.java))
        }
        findViewById<LinearLayout>(R.id.my_bids_bottom_nav).setOnClickListener {
            startActivity(Intent(this@NoticeBoardActivity, MyBidsActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.passbook_bottom_nav).setOnClickListener {
            startActivity(Intent(this@NoticeBoardActivity, PassbookActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.funds_bottom_nav).setOnClickListener {
            startActivity(Intent(this@NoticeBoardActivity, FundsActivity::class.java))
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
            val dialog = Dialog(this@NoticeBoardActivity)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.window!!.setBackgroundDrawableResource(R.drawable.white_round)
            dialog.setContentView(R.layout.session_expired_dialog_box)

            dialog.findViewById<Button>(R.id.yes_dialog_box)
                .setOnClickListener { dialog.cancel() }
            dialog.show()
        }

        navigation.findViewById<View>(R.id.ll_game_rates).setOnClickListener {
            startActivity(Intent(this@NoticeBoardActivity, GamesRatesActivity::class.java))
        }

        navigation.findViewById<View>(R.id.settings_nav).setOnClickListener {
            startActivity(Intent(this@NoticeBoardActivity, SettingsActivity::class.java))
        }

        navigation.findViewById<View>(R.id.notification).setOnClickListener {
            startActivity(Intent(this@NoticeBoardActivity, NotificationActivity::class.java))
        }

    }

    private fun setRecyclerView() {
        dummyList.add("lata morning")
        dummyList.add("sridevi")
        dummyList.add("time bazar")
        dummyList.add("madhur day")
        dummyList.add("rajadhani day")
        dummyList.add("milan day")
        dummyList.add("lata day")
        dummyList.add("supreme day")
        dummyList.add("kalyan")

        recyclerView = findViewById(R.id.recycler_view_dashboard)
        myViewHolderAdapter = object : RecyclerView.Adapter<MyViewHolder>() {
            override fun onCreateViewHolder(
                viewGroup: ViewGroup,
                ViewType: Int,
            ): MyViewHolder {
                return MyViewHolder(LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.blueprint_home_screen_items, viewGroup, false))
            }

            @SuppressLint("DefaultLocale", "SetTextI18n", "NotifyDataSetChanged",
                "UseCompatLoadingForDrawables")
            override fun onBindViewHolder(
                viewHolderRt: MyViewHolder,
                i: Int,
            ) {

                viewHolderRt.title.text = dummyList[i]

                if (i % 2 == 0) { // show bid close dialog box on even numbers
                    viewHolderRt.bidButton.text = "Closed for Today"
                } else {
                    // show menu
                    viewHolderRt.bidButton.text = "Running now"
                    viewHolderRt.bidButton.setTextColor(resources.getColor(R.color.green))
                }

                viewHolderRt.root.setOnClickListener {
                    if (i % 2 == 0) { // show bid close dialog box on even numbers
                        val dialog = Dialog(this@NoticeBoardActivity)
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                        dialog.setCancelable(false)
                        dialog.window!!.setBackgroundDrawableResource(R.drawable.white_round)
                        dialog.setContentView(R.layout.bid_closed_for_today_dialog_box)

                        dialog.findViewById<Button>(R.id.ok_dialog_box)
                            .setOnClickListener { dialog.cancel() }
                        dialog.show()
                    } else {
                        // show menu

                        startActivity(Intent(this@NoticeBoardActivity,
                            SelectGameActivity::class.java))
                    }

                }

            }

            override fun getItemCount(): Int {

                return dummyList.size
            }
        }

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = myViewHolderAdapter
    }

    override fun onBackPressed() {
        val dialog = Dialog(this@NoticeBoardActivity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.window!!.setBackgroundDrawableResource(R.drawable.white_round)
        dialog.setContentView(R.layout.quit_dialog_box)

        dialog.findViewById<Button>(R.id.no_dialog_box)
            .setOnClickListener { dialog.cancel() }

        dialog.findViewById<Button>(R.id.yes_dialog_box)
            .setOnClickListener { finishAffinity() }
        dialog.show()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var root: CardView = itemView.findViewById(R.id.root)
        var title: TextView = itemView.findViewById(R.id.title)
        var number: TextView = itemView.findViewById(R.id.number)
        var bidButton: TextView = itemView.findViewById(R.id.bid_button)
    }
}