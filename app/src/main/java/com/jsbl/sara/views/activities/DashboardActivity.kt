package com.jsbl.sara.views.activities

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.jsbl.sara.R
import com.jsbl.sara.databinding.ActivityDashboardBinding
import com.jsbl.sara.utils.RequestHandler
import com.jsbl.sara.utils.extensions.InactiveStateHandler
import com.jsbl.sara.utils.extensions.SessionVariable
import com.jsbl.sara.viewModel.MainHomeViewModel
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.navigation_drawer.*
import kotlinx.android.synthetic.main.navigation_drawer.view.*


class DashboardActivity :
    BaseActivity<MainHomeViewModel, ActivityDashboardBinding>(MainHomeViewModel::class.java) {

    lateinit var navController: NavController
    private val inactiveStateHandler: InactiveStateHandler by lazy {
        InactiveStateHandler(SessionVariable.sessionTimeout.toString()) {
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController()
        initMembers()
    }


    override fun onStart() {
        super.onStart()
        setDrawer()
//        initMembers()
    }

    fun navController() {
        val navHostFragment = this.findNavController(R.id.main_nav_host_fragment)
        navController = navHostFragment
        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigation.setupWithNavController(navController)
        bottomNavigation.menu.getItem(2).isChecked = true
    }

    private fun initMembers() {
        inactiveStateHandler.resetDisconnectTimer()
        inactiveStateHandler.setPagingComplete(true)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.nav_id_main_fragment -> {
                    toolbar_ll_dashboard.visibility = View.VISIBLE
                    header_text_main.visibility = View.VISIBLE
                    iv_dashboard_activity.visibility = View.VISIBLE
                    ll_dashboard_plays.visibility = View.VISIBLE
                    ll_contact_dashboard.visibility = View.VISIBLE
                    bottom_navigation.visibility = View.VISIBLE
                }
                R.id.nav_id_passbook_fragment -> {
                    toolbar_ll_dashboard.visibility = View.GONE
                    header_text_main.visibility = View.GONE
                    iv_dashboard_activity.visibility = View.GONE
                    ll_dashboard_plays.visibility = View.GONE
                    ll_contact_dashboard.visibility = View.GONE
                    bottom_navigation.visibility = View.VISIBLE
                }
                R.id.nav_id_funds_fragment -> {
                    toolbar_ll_dashboard.visibility = View.VISIBLE
                    header_text_main.visibility = View.GONE
                    iv_dashboard_activity.visibility = View.GONE
                    ll_dashboard_plays.visibility = View.GONE
                    ll_contact_dashboard.visibility = View.GONE
                    bottom_navigation.visibility = View.VISIBLE
                }
                R.id.nav_id_my_bids_fragment -> {
                    toolbar_ll_dashboard.visibility = View.VISIBLE
                    header_text_main.visibility = View.GONE
                    iv_dashboard_activity.visibility = View.GONE
                    ll_dashboard_plays.visibility = View.GONE
                    ll_contact_dashboard.visibility = View.GONE
                    bottom_navigation.visibility = View.VISIBLE
                }
                R.id.nav_id_support_fragment -> {
                    toolbar_ll_dashboard.visibility = View.VISIBLE
                    header_text_main.visibility = View.GONE
                    iv_dashboard_activity.visibility = View.GONE
                    ll_dashboard_plays.visibility = View.GONE
                    ll_contact_dashboard.visibility = View.GONE
                    bottom_navigation.visibility = View.VISIBLE
                }
                else -> {
                    toolbar_ll_dashboard.visibility = View.VISIBLE
                    header_text_main.visibility = View.GONE
                    iv_dashboard_activity.visibility = View.GONE
                    ll_dashboard_plays.visibility = View.GONE
                    ll_contact_dashboard.visibility = View.GONE
                    bottom_navigation.visibility = View.VISIBLE

                }
            }

        }
    }

    private fun setDrawer() {
        findViewById<ImageView>(R.id.menu).setOnClickListener {
            main_drawer.openDrawer(
                GravityCompat.START
            )
        }

        navigation.ll_game_rates.setOnClickListener {
            startActivity(Intent(this, GamesRatesActivity::class.java))
        }

    }


    override fun onBackPressed() {
        val dialog = Dialog(this@DashboardActivity)
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

    override fun onClick(view: View, obj: Any) {
    }

    override fun onLoading(obj: RequestHandler) {

    }

    override fun onSuccess(obj: RequestHandler) {
    }

    override fun onError(obj: RequestHandler) {
    }


    override fun getLayoutRes(): Int {
        return R.layout.activity_dashboard
    }

    override fun initViewModel(viewModel: MainHomeViewModel) {
    }


    fun loadFragment(fragmentId: Int) {
        navController.navigate(fragmentId)
    }

}