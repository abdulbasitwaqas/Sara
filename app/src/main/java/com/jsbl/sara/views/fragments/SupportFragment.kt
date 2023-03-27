package com.jsbl.sara.views.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import com.jsbl.sara.R
import com.jsbl.sara.databinding.FragmentSupportBinding
import com.jsbl.sara.utils.RequestHandler
import com.jsbl.sara.utils.SharePreferencesHelper
import com.jsbl.sara.viewModel.MainHomeViewModel
import com.scope.smartdrivedemo.FileLoggingTree


class SupportFragment :
    BaseFragment<MainHomeViewModel, FragmentSupportBinding>(
        MainHomeViewModel::class.java
    ) {


    var sharedEditor: SharedPreferences.Editor? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        sharedEditor = SharePreferencesHelper.prefs!!.edit()

        initMembers()

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
        return R.layout.fragment_support
    }

}