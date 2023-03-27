package com.jsbl.sara.network.retrofit

import com.jsbl.sara.network.retrofit.model.ApiResponse

abstract class BaseCallBack<T> {
    abstract fun onLoading()
    abstract fun onSuccess(response: ApiResponse<T>)
    abstract fun onFailure(response: ApiResponse<T>)
    abstract fun onSessionExpire()
}