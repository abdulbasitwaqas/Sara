package com.jsbl.sara.utils.eventBus

import android.content.Context
import android.content.Intent

interface ArrivedObjectListener {
    fun getIntent(context: Context?, intent: Intent?)
}