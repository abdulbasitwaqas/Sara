package com.jsbl.sara.Models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SupportFragmentResponse(
    @field:SerializedName("data")
    val data: String? = null
):Parcelable
