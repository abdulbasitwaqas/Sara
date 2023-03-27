package com.jsbl.sara.views.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.jsbl.sara.Models.FundsResponse
import com.jsbl.sara.R
import com.jsbl.sara.databinding.FragmentFundsBinding
import com.jsbl.sara.databinding.FragmentGameRatesBinding
import com.jsbl.sara.utils.RequestHandler
import com.jsbl.sara.utils.SharePreferencesHelper
import com.jsbl.sara.viewModel.MainHomeViewModel
import com.jsbl.sara.views.adapters.FundsAdapter
import com.scope.smartdrivedemo.FileLoggingTree


class GamesRateFragment :
    BaseFragment<MainHomeViewModel, FragmentGameRatesBinding>(
        MainHomeViewModel::class.java
    ) {

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
        return R.layout.fragment_game_rates
    }

}