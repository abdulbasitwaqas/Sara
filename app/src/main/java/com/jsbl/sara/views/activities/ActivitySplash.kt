package com.jsbl.sara.views.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.jsbl.sara.R
import com.jsbl.sara.databinding.ActivitySplashBinding
import com.jsbl.sara.utils.APP_TAG
import com.jsbl.sara.utils.RequestHandler
import com.jsbl.sara.utils.SharePreferencesHelper
import com.jsbl.sara.utils.logD
import com.jsbl.sara.viewModel.MainHomeViewModel


class ActivitySplash :
    BaseActivity<MainHomeViewModel, ActivitySplashBinding>(MainHomeViewModel::class.java) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        dontWaitJustStart()

    }

    override fun onClick(view: View, obj: Any) {
    }

    override fun onLoading(obj: RequestHandler) {
    }

    override fun onSuccess(obj: RequestHandler) {
    }

    override fun onError(obj: RequestHandler) {
    }

    fun dontWaitJustStart() {
        logD(APP_TAG, "Don't wait just start")

        Handler().postDelayed({
            val intent = Intent(this@ActivitySplash, ActLogin::class.java).putExtra(
                "show_referance_dialog",
                false
            )
            startActivity(intent)
            finish()
        }, 3000)

    }

    override fun getLayoutRes(): Int {
        return R.layout.activity_splash
    }

    override fun initViewModel(viewModel: MainHomeViewModel) {
    }


}