package com.jsbl.sara.Models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FundsResponse(

    @field:SerializedName("funds_action")
    val funds_action: String? = null,
    @field:SerializedName("description")
    val description: String? = null,
    @field:SerializedName("image")
    val image: String? = null

):Parcelable
