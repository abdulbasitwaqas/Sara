package com.jsbl.sara.Models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GetAppDataResponse(
    @field:SerializedName("version")
    val version: Int? = null,
    @field:SerializedName("home_message")
    val home_message: String? = null,
    @field:SerializedName("support_number")
    val support_number: String? = null,
    @field:SerializedName("support_number")
    val support_time: String? = null,
    @field:SerializedName("Withdrawl_condition")
    val withdrawl_condition: String? = null,
    @field:SerializedName("rules_notice")
    val rules_notice: String? = null,
    @field:SerializedName("min_withdraw")
    val min_withdraw: String? = null,
    @field:SerializedName("min_deposit")
    val min_deposit: String? = null,
    @field:SerializedName("invite_bonus")
    val invite_bonus: String? = null,
    @field:SerializedName("invite_system_enable")
    val invite_system_enable: Boolean? = false,
    @field:SerializedName("telegram_enable")
    val telegram_enable: Boolean? = false,
    @field:SerializedName("whtsapp_number")
    val whtsapp_number: String? = null,
    @field:SerializedName("withdraw_open_time")
    val withdraw_open_time: String? = null,
    @field:SerializedName("withdraw_close_time")
    val withdraw_close_time: String? = null,
    @field:SerializedName("bank_withdraw_enable")
    val bank_withdraw_enable: Boolean? = false,
    @field:SerializedName("upi_withdraw_enable")
    val upi_withdraw_enable: Boolean? = false,
    @field:SerializedName("enable_desawar")
    val enable_desawar: Boolean? = false,
    @field:SerializedName("enable_desawar_only")
    val enable_desawar_only: Boolean? = false
) : Parcelable