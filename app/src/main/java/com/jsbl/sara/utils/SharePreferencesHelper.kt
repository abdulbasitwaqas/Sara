package com.jsbl.sara.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.preference.PreferenceManager


class SharePreferencesHelper {

    // Test
    companion object {
        private const val PREFS_TIME = "prefs_time"
        private const val AUTH_TOKEN = "Auth_token"
        private const val CUSTOMER_ID = "customer_id"
        private const val SCOPE_PASS = "scope_pass"
        private const val SCOPE_NAME = "scope_name"
        private const val DefaultCarPos = "default_car_pos"
        private const val carPos = "car_pos"
         var prefs: SharedPreferences? = null
        var sharedEditor: SharedPreferences.Editor? = null

        @Volatile
        private var instance: SharePreferencesHelper? = null
        private var lock = Any()


        operator fun invoke(context: Context): SharePreferencesHelper =
            instance ?: kotlin.synchronized(lock) {
                instance ?: buildHelper(context).also {
                    instance = it
                }
            }

        private fun buildHelper(context: Context): SharePreferencesHelper {
            prefs = PreferenceManager.getDefaultSharedPreferences(context)
            return SharePreferencesHelper()
        }
    }

    fun updateTime(time: Long) {
        prefs?.edit(commit = true) {
            putLong(PREFS_TIME, time)
        }
    }

    fun updateAuth(auth: String) {
        prefs?.edit(commit = true) {
            putString(AUTH_TOKEN, auth)
        }
    }

    fun updateScopeName(auth: String) {
        prefs?.edit(commit = true) {
            putString(SCOPE_NAME, auth)
        }
    }

    fun updateScopePass(auth: String) {
        prefs?.edit(commit = true) {
            putString(SCOPE_PASS, auth)
        }
    }

    fun updateCustomerId(id: Long) {
        prefs?.edit(commit = true) {
            putLong(CUSTOMER_ID, id)
        }
    }

    fun setRegPassword(password: String) {
        prefs?.edit(commit = true) {
            putString(SCOPE_PASS, password)
        }
    }
    fun getRegPassword(): String = if (prefs != null) {
        prefs?.getString(SCOPE_PASS, "")!!
    } else {
        ""
    }

    fun setDefaultCarPos(postition: Int) {
        prefs?.edit(commit = true) {
            putInt(carPos, postition)
        }
    }
    fun getDefaultCarPos(): Int = if (prefs != null) {
        prefs?.getInt(carPos, 0)!!
    } else {
        0
    }

    fun setScopeToken(scopeToken: String) {
        prefs?.edit(commit = true) {
            putString(DefaultCarPos, scopeToken)
        }
    }
    fun getScopeToken(): String = if (prefs != null) {
        prefs?.getString(DefaultCarPos, "")!!
    } else {
        ""
    }



    fun getTime() = prefs?.getLong(PREFS_TIME, 0L)

    fun getAuth(): String = if (prefs != null) {
        prefs?.getString(AUTH_TOKEN, "")!!
    } else {
        ""
    }
    fun getScopeName(): String = if (prefs != null) {
        prefs?.getString(SCOPE_NAME, "")!!
    } else {
        ""
    }

    fun getScopePass(): String = if (prefs != null) {
        prefs?.getString(SCOPE_PASS, "")!!
    } else {
        ""
    }


    fun getCustomerId(): Long = if (prefs != null) {
        prefs?.getLong(CUSTOMER_ID, 0)!!
    } else {
        0
    }

    fun getCachePreferences() = prefs?.getString("duration", "")

    fun logout(){
        prefs?.edit()!!.clear().commit()
    }


}