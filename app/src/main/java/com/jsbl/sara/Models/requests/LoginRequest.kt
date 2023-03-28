package com.jsbl.sara.Models.requests

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @field:SerializedName("phone")
    val mobile: String? = null,

    @field:SerializedName("mpin")
    val mpin: String? = null,

    @field:SerializedName("fcm")
    val fcm: String? = null
)
