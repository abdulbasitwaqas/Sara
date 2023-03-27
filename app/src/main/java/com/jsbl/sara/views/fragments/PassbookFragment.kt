package com.jsbl.sara.views.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.jsbl.sara.Models.DashboardResponse
import com.jsbl.sara.Models.PassbookResponse
import com.jsbl.sara.R
import com.jsbl.sara.adapters.DashBoardAdapter
import com.jsbl.sara.databinding.FragmentPassbookBinding
import com.jsbl.sara.utils.RequestHandler
import com.jsbl.sara.utils.SharePreferencesHelper
import com.jsbl.sara.viewModel.MainHomeViewModel
import com.jsbl.sara.views.adapters.PassbookAdapter
import com.scope.smartdrivedemo.FileLoggingTree
import kotlinx.android.synthetic.main.fragment_passbook.*
import kotlinx.android.synthetic.main.navigation_drawer.*


class PassbookFragment :
    BaseFragment<MainHomeViewModel, FragmentPassbookBinding>(
        MainHomeViewModel::class.java
    ) {

    lateinit var passbookResponse: MutableList<PassbookResponse>
    lateinit var passbookAdapter: PassbookAdapter
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

        back_btn_passbook.setOnClickListener {
            getFragmentManager()?.popBackStack()
        }

    }

    override fun onClick(view: View, obj: Any) {
    }

    override fun onLoading(obj: RequestHandler) {
    }

    override fun onSuccess(obj: RequestHandler) {
    }

    override fun onError(obj: RequestHandler) {
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
        return R.layout.fragment_passbook
    }


    fun initMembers() {


        binding.apply {

            passbookResponse = mutableListOf(
                PassbookResponse(
                    "22 Mar 2023 02:10 PM",
                    "Bid ( MILAN NIGHT : Double Pana : CLOSE ) :\\n110",
                    "₹1000.00",
                    "₹190.00",
                    "₹810.00"
                ),
                PassbookResponse(
                    "22 Mar 2023 02:10 PM",
                    "Bid ( MILAN NIGHT : Double Pana : CLOSE ) :\\n110",
                    "₹1000.00",
                    "₹190.00",
                    "₹810.00"
                ),
                PassbookResponse(
                    "22 Mar 2023 02:10 PM",
                    "Bid ( MILAN NIGHT : Double Pana : CLOSE ) :\\n110",
                    "₹1000.00",
                    "₹190.00",
                    "₹810.00"
                ),
                PassbookResponse(
                    "22 Mar 2023 02:10 PM",
                    "Bid ( MILAN NIGHT : Double Pana : CLOSE ) :\\n110",
                    "₹1000.00",
                    "₹190.00",
                    "₹810.00"
                ),
                PassbookResponse(
                    "22 Mar 2023 02:10 PM",
                    "Bid ( MILAN NIGHT : Double Pana : CLOSE ) :\\n110",
                    "₹1000.00",
                    "₹190.00",
                    "₹810.00"
                ),
                PassbookResponse(
                    "22 Mar 2023 02:10 PM",
                    "Bid ( MILAN NIGHT : Double Pana : CLOSE ) :\\n110",
                    "₹1000.00",
                    "₹190.00",
                    "₹810.00"
                ),
                PassbookResponse(
                    "22 Mar 2023 02:10 PM",
                    "Bid ( MILAN NIGHT : Double Pana : CLOSE ) :\\n110",
                    "₹1000.00",
                    "₹190.00",
                    "₹810.00"
                ),
                PassbookResponse(
                    "22 Mar 2023 02:10 PM",
                    "Bid ( MILAN NIGHT : Double Pana : CLOSE ) :\\n110",
                    "₹1000.00",
                    "₹190.00",
                    "₹810.00"
                ),
                PassbookResponse(
                    "22 Mar 2023 02:10 PM",
                    "Bid ( MILAN NIGHT : Double Pana : CLOSE ) :\\n110",
                    "₹1000.00",
                    "₹190.00",
                    "₹810.00"
                ),
                PassbookResponse(
                    "22 Mar 2023 02:10 PM",
                    "Bid ( MILAN NIGHT : Double Pana : CLOSE ) :\\n110",
                    "₹1000.00",
                    "₹190.00",
                    "₹810.00"
                ),
                PassbookResponse(
                    "22 Mar 2023 02:10 PM",
                    "Bid ( MILAN NIGHT : Double Pana : CLOSE ) :\\n110",
                    "₹1000.00",
                    "₹190.00",
                    "₹810.00"
                ),
                PassbookResponse(
                    "22 Mar 2023 02:10 PM",
                    "Bid ( MILAN NIGHT : Double Pana : CLOSE ) :\\n110",
                    "₹1000.00",
                    "₹190.00",
                    "₹810.00"
                ),
                PassbookResponse(
                    "22 Mar 2023 02:10 PM",
                    "Bid ( MILAN NIGHT : Double Pana : CLOSE ) :\\n110",
                    "₹1000.00",
                    "₹190.00",
                    "₹810.00"
                ),
                PassbookResponse(
                    "22 Mar 2023 02:10 PM",
                    "Bid ( MILAN NIGHT : Double Pana : CLOSE ) :\\n110",
                    "₹1000.00",
                    "₹190.00",
                    "₹810.00"
                ),
                PassbookResponse(
                    "22 Mar 2023 02:10 PM",
                    "Bid ( MILAN NIGHT : Double Pana : CLOSE ) :\\n110",
                    "₹1000.00",
                    "₹190.00",
                    "₹810.00"
                ),
            )

            passbookAdapter = PassbookAdapter(passbookResponse)
            recyclerView.adapter = passbookAdapter
            passbookAdapter.onItemClick = { activeSummaryResponse ->
                /* Navigation.findNavController(mBinding.root)
                     .navigate(R.id.action_open_summary_listing_fragment_to_approval_summary_fragment)*/
            }

        }


    }

}