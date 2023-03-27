package com.jsbl.sara.views.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.jsbl.sara.Models.DashboardResponse
import com.jsbl.sara.R
import com.jsbl.sara.adapters.DashBoardAdapter
import com.jsbl.sara.databinding.FragmentDashboardBinding
import com.jsbl.sara.utils.RequestHandler
import com.jsbl.sara.utils.SharePreferencesHelper
import com.jsbl.sara.viewModel.MainHomeViewModel
import com.scope.smartdrivedemo.FileLoggingTree


class DashbaordFragment :
    BaseFragment<MainHomeViewModel, FragmentDashboardBinding>(
        MainHomeViewModel::class.java
    ) {

    lateinit var dashboardResponse : MutableList<DashboardResponse>
    lateinit var dashBoardAdapter : DashBoardAdapter


    var sharedEditor: SharedPreferences.Editor? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showPDialog()


        sharedEditor = SharePreferencesHelper.prefs!!.edit()

        Handler().postDelayed({
            dismissDialog()
            initMembers()
        }, 1000)


        FileLoggingTree.checkForObsoleteLogFiles(requireContext().applicationContext)




    }

    override fun onClick(view: View, obj: Any) {
        
    }

    override fun onLoading(obj: RequestHandler) {
        
    }

    override fun onSuccess(obj: RequestHandler) {
        
    }

    override fun onError(obj: RequestHandler) {

    }

    fun initMembers(){


        binding.apply {

            dashboardResponse = mutableListOf(
                DashboardResponse(
                    "Lata morning",
                    "21 Mar 2023 04:10 AM",
                    "23 Mar 2023 02:10 AM",
                    "APE-12399",
                    "Bid Closed"
                ),
                DashboardResponse(
                    "Devine Goge",
                    "12 Mar 2023 12:10 PM",
                    "12 Mar 2023 02:10 PM",
                    "APD-23423n",
                    "Bid Closed"
                ),
                DashboardResponse(
                    "NEW DOGE",
                    "10 Mar 2023 09:10 AM",
                    "10 Mar 2023 12:10 PM",
                    "ADE-nvas990",
                    "Bid Closed"
                ),
                DashboardResponse(
                    "NEW DOGE",
                    "10 Mar 2023 09:10 AM",
                    "10 Mar 2023 12:10 PM",
                    "ADE-nvas990",
                    "Bid Closed"
                ),
                DashboardResponse(
                    "NEW DOGE",
                    "10 Mar 2023 09:10 AM",
                    "10 Mar 2023 12:10 PM",
                    "ADE-nvas990",
                    "Bid Closed"
                ),
                DashboardResponse(
                    "NEW DOGE",
                    "10 Mar 2023 09:10 AM",
                    "10 Mar 2023 12:10 PM",
                    "ADE-nvas990",
                    "Bid Closed"
                ),
                DashboardResponse(
                    "NEW DOGE",
                    "10 Mar 2023 09:10 AM",
                    "10 Mar 2023 12:10 PM",
                    "ADE-nvas990",
                    "Bid Closed"
                ),
                DashboardResponse(
                    "NEW DOGE",
                    "10 Mar 2023 09:10 AM",
                    "10 Mar 2023 12:10 PM",
                    "ADE-nvas990",
                    "Bid Closed"
                ),
                DashboardResponse(
                    "NEW DOGE",
                    "10 Mar 2023 09:10 AM",
                    "10 Mar 2023 12:10 PM",
                    "ADE-nvas990",
                    "Bid Closed"
                ),
                DashboardResponse(
                    "NEW DOGE",
                    "10 Mar 2023 09:10 AM",
                    "10 Mar 2023 12:10 PM",
                    "ADE-nvas990",
                    "Bid Closed"
                ),
                DashboardResponse(
                    "NEW DOGE",
                    "10 Mar 2023 09:10 AM",
                    "10 Mar 2023 12:10 PM",
                    "ADE-nvas990",
                    "Bid Closed"
                ),
                DashboardResponse(
                    "NEW DOGE",
                    "10 Mar 2023 09:10 AM",
                    "10 Mar 2023 12:10 PM",
                    "ADE-nvas990",
                    "Bid Closed"
                ),
                DashboardResponse(
                    "NEW DOGE",
                    "10 Mar 2023 09:10 AM",
                    "10 Mar 2023 12:10 PM",
                    "ADE-nvas990",
                    "Bid Closed"
                ),
                DashboardResponse(
                    "NEW DOGE",
                    "10 Mar 2023 09:10 AM",
                    "10 Mar 2023 12:10 PM",
                    "ADE-nvas990",
                    "Bid Closed"
                ),
                DashboardResponse(
                    "NEW DOGE",
                    "10 Mar 2023 09:10 AM",
                    "10 Mar 2023 12:10 PM",
                    "ADE-nvas990",
                    "Bid Closed"
                )
            )

            dashBoardAdapter = DashBoardAdapter(dashboardResponse)


            recyclerViewDashboard.adapter = dashBoardAdapter
            dashBoardAdapter.onItemClick = { activeSummaryResponse ->
               /* Navigation.findNavController(mBinding.root)
                    .navigate(R.id.action_open_summary_listing_fragment_to_approval_summary_fragment)*/
            }

        }


    }





    fun isItFirestTime(): Boolean {
        return if (SharePreferencesHelper.prefs!!.getBoolean("firstTime", true)) {
            sharedEditor!!.putBoolean("firstTime", false)
            sharedEditor!!.commit()
            sharedEditor!!.apply()
            true
        } else {
            false
        }
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_dashboard
    }

}