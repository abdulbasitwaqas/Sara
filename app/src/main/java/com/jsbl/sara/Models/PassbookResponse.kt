package com.jsbl.sara.Models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PassbookResponse(

    @field:SerializedName("transaction_date")
    val transaction_date: String? = null,
    @field:SerializedName("particulars")
    val particulars: String? = null,
    @field:SerializedName("previous_amount")
    val previous_amount: String? = null,
    @field:SerializedName("transaction_amount")
    val transaction_amount: String? = null,
    @field:SerializedName("current_amount")
    val current_amount: String? = null,

):Parcelable
