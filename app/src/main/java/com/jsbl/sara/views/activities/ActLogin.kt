package com.jsbl.sara.views.activities

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import com.jsbl.sara.Models.requests.LoginRequest
import com.jsbl.sara.R
import com.jsbl.sara.databinding.ActivityLoginBinding
import com.jsbl.sara.utils.RequestHandler
import com.jsbl.sara.viewModel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*

class ActLogin  : BaseActivity<LoginViewModel, ActivityLoginBinding>(LoginViewModel::class.java){


    private var edittext: String = ""
    private var mpin: String = ""
    var fcm: String = ""
    private var referenceCode:String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.onClickListener = this


        login.setOnClickListener {
            startActivity(Intent(this@ActLogin, DashboardActivity::class.java))
        }
    }

    override fun onClick(view: View, obj: Any) {
        when (view.id) {
            R.id.login -> {
                viewModel.isForgetPass = false
                edittext = binding.etMobile.text.toString().trim()
                mpin = binding.etMpin.text.toString().trim()
                fcm = binding.etOtp.text.toString().trim()
                //request
                if (validateMobileNo() && validateMPin() && validateOTP()) {
                    val loginVal = LoginRequest(edittext, mpin, fcm)
                    viewModel.loginUser(edittext, mpin, fcm)
                }
            }
            R.id.forget_password -> {
                val dialog = Dialog(this)
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                dialog.setCancelable(true)
                val window: Window = dialog.window!!
                val wlp = window.attributes
                wlp.gravity = Gravity.BOTTOM
                wlp.flags = wlp.flags and WindowManager.LayoutParams.FLAG_DIM_BEHIND.inv()
                window.attributes = wlp
                val attributes = window.attributes
                attributes.y = 80
                dialog.window!!.attributes = attributes

                dialog.window!!.setBackgroundDrawableResource(R.drawable.white_round)
                dialog.setContentView(R.layout.forget_password_dialog_box)

                dialog.findViewById<Button>(R.id.submit)
                    .setOnClickListener {
                        dialog.cancel()
                        startActivity(Intent(this@ActLogin, ForgetPasswordActivity::class.java))
                    }

                dialog.findViewById<ImageView>(R.id.iv_cross)
                    .setOnClickListener {
                        dialog.cancel()
                    }
                dialog.show()
            }

        }
    }

    override fun onLoading(obj: RequestHandler) {
        showPDialog()
    }

    override fun onSuccess(obj: RequestHandler) {
        dismissDialog()
    }

    override fun onError(obj: RequestHandler) {
        dismissDialog()
    }

    override fun getLayoutRes() = R.layout.activity_login

    override fun initViewModel(viewModel: LoginViewModel) {
    }


    private fun validateMobileNo(): Boolean {
        return if (edittext.isNotEmpty()) {
            binding.etMobile.error = null
            true
        } else {
            binding.etMobile.error = getString(R.string.error_valid_user_name)
            false
        }
    }


    private fun validateMPin(): Boolean {
        return if (mpin.isNotEmpty()
        ) {
            binding.etMpin.error = null
            true
        } else {
            binding.etMpin.error = getString(R.string.enter_mpin)
            false
        }
    }


    private fun validateOTP(): Boolean {
        return if (fcm.isNotEmpty()) {
            binding.etOtp.error = null
            true
        } else {
            binding.etOtp.error = getString(R.string.enter_otp)
            false
        }
    }

}