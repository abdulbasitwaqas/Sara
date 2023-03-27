package com.jsbl.sara.network

import com.jsbl.sara.Models.GetAppDataResponse
import com.jsbl.sara.Models.requests.GetAppDataRequest
import com.jsbl.sara.Models.requests.LoginRequest
import com.jsbl.sara.Models.response.LoginResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LocalApi {


    @POST("get-app-data")
     fun getSettings(@Body getAppDataRequest: GetAppDataRequest): Response<GetAppDataResponse>

    @POST("login-user")
     fun loginUser(@Body request: LoginRequest): Call<LoginResponse>


    /*  @POST("Feedback/GetCustomerFeedbackQuestions?UserID=")
      fun addFeedbackQuestions(@Body postFeedBack: PostFeedBack): Call<JsonObject>

    @POST("Feedback/GetCustomerFeedbackQuestions")
    fun addFeedbackQuestions(
        @Query("UserID") userID: String
    ): Call<List<FeedBackQuestionsModel>>

 feedback post api

    @POST("Feedback/GetCustomerFeedbackQuestions")
    fun addFeedbackQuestions(@Body getCustomerFeedbackModel: GetCustomerFeedbackModel): Call<List<FeedBackQuestionsModel>>
*/


}