package com.jsbl.sara.utils.callBacks

import com.jsbl.sara.utils.RequestHandler

interface NetworkListener {
    fun onLoading(obj: RequestHandler)
    fun onSuccess(obj: RequestHandler)
    fun onError(obj: RequestHandler)
}