package com.jsbl.sara.views.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.jsbl.sara.Models.MyBidsResponse
import com.jsbl.sara.R
import com.jsbl.sara.databinding.FragmentMyBidsBinding
import com.jsbl.sara.utils.RequestHandler
import com.jsbl.sara.utils.SharePreferencesHelper
import com.jsbl.sara.viewModel.MainHomeViewModel
import com.jsbl.sara.views.adapters.MyBidsAdapter
import com.scope.smartdrivedemo.FileLoggingTree


class MyBidsFragment :
    BaseFragment<MainHomeViewModel, FragmentMyBidsBinding>(
        MainHomeViewModel::class.java
    ) {

    lateinit var myBidsResponse: MutableList<MyBidsResponse>
    lateinit var myBidsAdapter: MyBidsAdapter
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

    fun initMembers() {
        binding.apply {

            myBidsResponse = mutableListOf(
                MyBidsResponse(
                    "Bid Closed",
                    "You have lost 400 INR",
                    ""
                ),
                MyBidsResponse(
                    "Bid Closed",
                    "You have earned 1000 INR",
                    ""
                ),
                MyBidsResponse(
                    "Bid Closed",
                    "You have earned 1000 INR",
                    ""
                ),
                MyBidsResponse(
                    "Bid Closed",
                    "You have earned 1000 INR",
                    ""
                ),
                MyBidsResponse(
                    "Bid Closed",
                    "You have earned 1000 INR",
                    ""
                ),
                MyBidsResponse(
                    "Bid Closed",
                    "You have earned 1000 INR",
                    ""
                ),
                MyBidsResponse(
                    "Bid Closed",
                    "You have earned 1000 INR",
                    ""
                ),
                MyBidsResponse(
                    "Bid Closed",
                    "You have earned 1000 INR",
                    ""
                ),
                MyBidsResponse(
                    "Bid Closed",
                    "You have earned 1000 INR",
                    ""
                ),
                MyBidsResponse(
                    "Bid Closed",
                    "You have earned 1000 INR",
                    ""
                ),
                MyBidsResponse(
                    "Bid Closed",
                    "You have earned 1000 INR",
                    ""
                ),
                MyBidsResponse(
                    "Bid Closed",
                    "You have earned 1000 INR",
                    ""
                ),
                MyBidsResponse(
                    "Bid Closed",
                    "You have earned 1000 INR",
                    ""
                ),
                MyBidsResponse(
                    "Bid Closed",
                    "You have earned 1000 INR",
                    ""
                ),
            )

            myBidsAdapter = MyBidsAdapter(myBidsResponse)

            rvMyBids.adapter = myBidsAdapter
            myBidsAdapter.onItemClick = { activeSummaryResponse ->
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
        return R.layout.fragment_my_bids
    }

}