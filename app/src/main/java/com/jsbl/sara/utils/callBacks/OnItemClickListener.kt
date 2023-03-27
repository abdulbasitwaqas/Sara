package com.jsbl.sara.utils.callBacks

import android.view.View


interface OnItemClickListener {
    fun onItemClick(view: View, pos: Int, obj: Any)
}