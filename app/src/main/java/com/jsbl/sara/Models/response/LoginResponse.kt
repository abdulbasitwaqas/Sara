package com.jsbl.sara.Models.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @field:SerializedName("is_new_user")
    val is_new_user: Boolean? = null,

    @field:SerializedName("is_blocked")
    val is_blocked: Boolean? = null,

    @field:SerializedName("User")
    val User: User? = null,

    @field:SerializedName("WithdrawDetails")
    val WithdrawDetails: WithdrawDetails? = null
)

data class User(
    @field:SerializedName("user_id")
    val user_id: Int? = null
)
data class WithdrawDetails(
    @field:SerializedName("draw_id")
    val draw_id: Int? = null
)
