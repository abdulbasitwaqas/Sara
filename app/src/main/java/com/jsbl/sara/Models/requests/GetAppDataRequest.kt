package com.jsbl.sara.Models.requests

import com.google.gson.annotations.SerializedName


data class GetAppDataRequest(
    @field:SerializedName("user_id")
    val user_id: String? = null
)
