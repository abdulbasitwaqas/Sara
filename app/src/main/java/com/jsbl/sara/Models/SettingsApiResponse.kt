package com.jsbl.sara.Models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue



@Parcelize
data class SettingsApiResponse(

    @field:SerializedName("error")
    val error: Boolean? = false,

    @field:SerializedName("data")
    val data: String? = null,


    @field:SerializedName("data2")
    val data2: String? = null,

) : Parcelable