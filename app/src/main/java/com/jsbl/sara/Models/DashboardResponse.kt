package com.jsbl.sara.Models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DashboardResponse(
    @field:SerializedName("header_name")
    val headerName: String? = null,

    @field:SerializedName("open_bid_time")
    val open_bid_time: String? = null,

    @field:SerializedName("close_bid_time")
    val close_bid_time: String? = null,

    @field:SerializedName("bid_number")
    val bid_number: String? = null,

    @field:SerializedName("status")
    val status: String? = null

) : Parcelable
