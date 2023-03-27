package com.jsbl.sara.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jsbl.sara.Encrpition.Constaint
import com.jsbl.sara.Encrpition.Cryptography_Android
import com.jsbl.sara.Encrpition.SendEncryptionRequest
import com.jsbl.sara.di.components.DaggerServiceComponent
import com.jsbl.sara.di.modules.AppModule
import com.jsbl.sara.di.modules.CONTEXT_APP
import com.jsbl.sara.di.modules.typeOfContext
import com.jsbl.sara.network.LocalService
import com.jsbl.sara.network.ScopeApiServices
import com.jsbl.sara.network.ScopeRetrofitClient
import com.jsbl.sara.utils.*
import com.scope.portalapiclient.PortalApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel(application: Application) : AndroidViewModel(application),
    CoroutineScope {
    private val job = Job()
    val requestHandlerMLD = MutableLiveData<RequestHandler>()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
    protected lateinit var scopeApiService: ScopeApiServices



    @Inject
    lateinit var localService: LocalService

    @Inject
    @field:typeOfContext(CONTEXT_APP)
    lateinit var prefsHelper: SharePreferencesHelper



    init {
        DaggerServiceComponent.builder()
            .appModule(AppModule(getApplication()))
            .build()
            .injectIntoBaseViewModel(this)
        scopeApiService = ScopeRetrofitClient.apiScopeServices(context = getApplication())
    }



    open fun sendRequest() {
        logD(APP_TAG, "method sendRequest")
        requestHandlerMLD.value = RequestHandler(
            loading = true,
            isSuccess = false,
            any = null
        )
    }

    open fun setError(
        obj: Any?,
        msg: String? = null,
        showAlert: Boolean = false,
        t: Throwable? = null
    ) {

        /*       val sendEncrptRequest: SendEncryptionRequest? = obj as SendEncryptionRequest
               val jsonString: String = sendEncrptRequest?.getText().toString()
               val decrypted: String = Cryptography_Android.Decrypt(
                   jsonString,
                   Constaint.mKey
               )
               val gson = Gson()
               val token: TypeToken<String> =
                   object : TypeToken<String>() {}
               val errorMsg: String = gson.fromJson(decrypted, token.type)

       */

        if (!showAlert) {
            requestHandlerMLD.value = RequestHandler(
                loading = false,
                isSuccess = false,
                any = obj
            )

            /*if (msg != null) {
                showShort(getApplication(), msg)

            } else*/
            if (t != null) {
                showShort(getApplication(), t.localizedMessage)
            } else {
                if (obj is Response<*>) {
                    if (obj.code() == 401) {
                        logout()
//                        return
                    }
                    if (obj.errorBody() != null) {
                        val msg2 = obj.errorBody()!!.string()

                        //decryption start
                        try {
                            val gsonError = Gson()
                            val typeTokenError: TypeToken<SendEncryptionRequest> =
                                object : TypeToken<SendEncryptionRequest>() {}
                            val errorMsg: SendEncryptionRequest =
                                gsonError.fromJson(msg2, typeTokenError.type)
                            val jsonString: String = errorMsg?.getText().toString()
                            val decrypted: String = Cryptography_Android.Decrypt(
                                jsonString,
                                Constaint.mKey
                            )
                            val gson = Gson()
                            val token: TypeToken<String> =
                                object : TypeToken<String>() {}
                            val error: String = gson.fromJson(decrypted, token.type)
                            // decryption end

                            if (!error.isNullOrEmpty()) {
                                showShort(getApplication(), error)
                            } else {
                                showShort(getApplication(), obj.message()!!)
                            }
                        } catch (e: Exception) {
                            showShort(getApplication(), msg2)
                        }

                    }
                /* else if (){
                        showShort(getApplication(), obj.message()!!)
                    }*/

                } else if (obj is Call<*>) {
                    /* val call = obj as Call<*>
                     showShort(getApplication(),call.request )*/
//                    showShort(getApplication(), "Request Timeout")
                    showShort(getApplication(), "" + msg)

                }
                else {
                    if (msg != null) {
                        requestHandlerMLD.value = RequestHandler(
                            loading = false,
                            isSuccess = false,
                            showAlert = true,
                            any = msg
                        )

                    } else {
                        requestHandlerMLD.value = RequestHandler(
                            loading = false,
                            isSuccess = false,
                            showAlert = true,
                            any = obj
                        )
                    }

//                    showShort(getApplication(), "Something went wrong! Please try again")
                }
            }
        } else {
            if (msg != null) {
                requestHandlerMLD.value = RequestHandler(
                    loading = false,
                    isSuccess = false,
                    showAlert = true,
                    any = msg
                )

            } else {
                requestHandlerMLD.value = RequestHandler(
                    loading = false,
                    isSuccess = false,
                    showAlert = true,
                    any = obj
                )
            }
        }

    }

    public fun logout() {

        try {
            SharePreferencesHelper(getApplication()).updateAuth("")
            SharePreferencesHelper(getApplication()).updateScopeName("")
            SharePreferencesHelper(getApplication()).updateScopePass("")
            SharePreferencesHelper(getApplication()).updateCustomerId(-1)
            SharePreferencesHelper(getApplication()).setDefaultCarPos(0)
//            SharePreferencesHelper(getApplication()).setScopeToken("")
            SharePreferencesHelper(getApplication()).setRegPassword("")
            SharePreferencesHelper(getApplication()).logout()

            Timber.i("Logout!")
            PortalApi.logout()

        } catch (e: Exception) {

        }
    }



    open fun setSuccess(obj: Any?) {
        requestHandlerMLD.value = RequestHandler(
            loading = false,
            isSuccess = true,
            any = obj
        )
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}