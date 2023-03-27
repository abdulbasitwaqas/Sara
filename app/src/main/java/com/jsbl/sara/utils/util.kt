package com.jsbl.sara.utils

import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.jsbl.sara.BuildConfig
import com.jsbl.sara.R
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*


val REQUEST_CODE_SEND_SMS = 2324


fun getProgressDrawable(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 10f
        centerRadius = 50f
        start()
    }
}

fun ImageView.loadProfile(url: String?, progressDrawable: CircularProgressDrawable) {

    if (url == null) return
    if (url.equals("")) return
    val options: RequestOptions = RequestOptions()
        .placeholder(progressDrawable)
        .error(R.drawable.ic_login_profile_avatar)
    Glide.with(context)
        .setDefaultRequestOptions(options)
//        .load(BuildConfig.BASE_URL_IMAGES + url.trim())
        .load(BuildConfig.BASE_URL + url.trim())
        .into(this)
}

fun ImageView.loadManufacturerIcon(url: String?, progressDrawable: CircularProgressDrawable) {

    if (url == null) return
    if (url.equals("")) return
    val options: RequestOptions = RequestOptions()
        .placeholder(R.drawable.ic_default_interest)
        .error(R.drawable.ic_default_interest)
    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(BuildConfig.BASE_URL + url.trim())
        .into(this)
}

fun ImageView.loadAOI(url: String?, progressDrawable: CircularProgressDrawable) {

    if (url == null) return
    if (url.equals("")) return
    val options: RequestOptions = RequestOptions()
        .placeholder(R.drawable.place_holder)
        .error(R.drawable.place_holder)
    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(BuildConfig.BASE_URL + url.trim())
        .into(this)
}

fun ImageView.loadCarColorMain(url: String?, progressDrawable: CircularProgressDrawable) {

    if (url == null) return
    if (url.equals("")) return
    val options: RequestOptions = RequestOptions()
        .placeholder(R.drawable.place_holder)
        .error(R.drawable.new_ic_btn_vector_car_detail_icon)
    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(BuildConfig.BASE_URL + url.trim())
        .into(this)
}

/**
 * extension method for [ImageView] for loading new Image
 */
fun ImageView.loadCnic(url: String?, progressDrawable: CircularProgressDrawable) {

    if (url == null) return
    if (url.equals("")) return
    val options: RequestOptions = RequestOptions()
        .placeholder(progressDrawable)
        .error(R.drawable.ic_outline_image_24)
    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(BuildConfig.BASE_URL + url.trim())
        .into(this)
}

@BindingAdapter("android:profileImage")
fun loadProfile(view: ImageView, url: String?) {
    if (url == null) return
    if (url.equals("")) return
    view.loadProfile(url, getProgressDrawable(view.context))
}

@BindingAdapter("android:loadManufacturerIcon")
fun loadManufacturerIcon(view: ImageView, url: String?) {
    if (url == null) return
    if (url.equals("")) return
    view.loadManufacturerIcon(url, getProgressDrawable(view.context))
}

@BindingAdapter("android:loadAOIIcon")
fun loadAOIIcon(view: ImageView, url: String?) {
    if (url == null) return
    if (url.equals("")) return
    view.loadAOI(url, getProgressDrawable(view.context))
}


@BindingAdapter("android:loadCarColor")
fun loadCarColor(view: ImageView, url: String?) {
    if (url == null) return
    if (url.equals("")) return
    view.loadCarColorMain(url, getProgressDrawable(view.context))
}

@BindingAdapter("app:startDateFormat")
fun startDate(view: View, text: String?) {
    (view as AppCompatTextView).text = if (text == null || text.isEmpty()) {
        ""
    } else {
        val simpleDateFormat = SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.getDefault())
        val date = simpleDateFormat.parse(text)
        simpleDateFormat.applyPattern("dd MMM, yyyy")
        "Started on " + simpleDateFormat.format(date)
    }
}

@BindingAdapter("app:endDateFormat")
fun endDate(view: View, text: String?) {
    (view as AppCompatTextView).text = if (text == null || text.isEmpty()) {
        ""
    } else {
        val simpleDateFormat = SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.getDefault())
        val date = simpleDateFormat.parse(text)
        simpleDateFormat.applyPattern("dd MMM, yyyy")
        "Completed on " + simpleDateFormat.format(date)
    }
}

@BindingAdapter("app:expireDateFormat")
fun expireDate(view: View, text: String?) {
    (view as AppCompatTextView).text = if (text == null || text.isEmpty()) {
        ""
    } else {
        val simpleDateFormat = SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.getDefault())
        val date = simpleDateFormat.parse(text)
        simpleDateFormat.applyPattern("dd MMM, yyyy")
        "Expires on \n" + simpleDateFormat.format(date)
    }
}

@BindingAdapter("android:cnicImage")
fun loadCnic(view: ImageView, url: String?) {
    if (url == null) return
    if (url.equals("")) return
    view.loadCnic(url, getProgressDrawable(view.context))
}

@BindingAdapter("setDrawable")
fun setImageUri(view: ImageView, imageUri: String?) {
    if (imageUri == null) {
        view.setImageURI(null)
    } else {
        view.setImageURI(Uri.parse(imageUri))
    }
}

@BindingAdapter("setDrawable")
fun setImageUri(view: ImageView, imageUri: Uri?) {
    view.setImageURI(imageUri)
}

@BindingAdapter("setDrawable")
fun setImageDrawable(view: ImageView, drawable: Drawable?) {
    view.setImageDrawable(drawable)
}

@BindingAdapter("setDrawable")
fun setImageResource(imageView: ImageView, resource: Int) {
    imageView.setImageResource(resource)
}

fun getDaysCount(begin: Date?, end: Date?): Int {
    val start: Calendar = Calendar.getInstance()
    start.time = begin
    start[Calendar.MILLISECOND] = 0
    start[Calendar.SECOND] = 0
    start[Calendar.MINUTE] = 0
    start[Calendar.HOUR_OF_DAY] = 0
    val finish: Calendar = Calendar.getInstance()
    finish.time = end
    finish[Calendar.MILLISECOND] = 999
    finish[Calendar.SECOND] = 59
    finish[Calendar.MINUTE] = 59
    finish[Calendar.HOUR_OF_DAY] = 23
    val delta = finish.timeInMillis - start.timeInMillis
    return Math.floor(delta / (1000.0 * 60 * 60 * 24)).toInt()
}

fun getTimeLeft(date: String): String { // dateFormat = "yyyy-MM-dd"
    val DateSplit = date.split("-").toTypedArray()
    val month = DateSplit[1].toInt() - 1
    // if month is november  then subtract by 1
    val year = DateSplit[0].toInt()
    val day = DateSplit[2].toInt()
    val hour = 0
    val minute = 0
    val second = 0
    val now = Calendar.getInstance()
    var sec = second - Calendar.getInstance()[Calendar.SECOND]
    var min = (minute
            - Calendar.getInstance()[Calendar.MINUTE])
    var hr = (hour
            - Calendar.getInstance()[Calendar.HOUR_OF_DAY])
    var dy = (day
            - Calendar.getInstance()[Calendar.DATE])
    var mnth = (month
            - Calendar.getInstance()[Calendar.MONTH])
    val daysinmnth = 32 - dy
    val end = Calendar.getInstance()
    end[year, month] = day
    if (mnth != 0) {
        if (dy != 0) {
            if (sec < 0) {
                sec = (sec + 60) % 60
                min--
            }
            if (min < 0) {
                min = (min + 60) % 60
                hr--
            }
            if (hr < 0) {
                hr = (hr + 24) % 24
                dy--
            }
            if (dy < 0) {
                dy = (dy + daysinmnth) % daysinmnth
                mnth--
            }
            if (mnth < 0) {
                mnth = (mnth + 12) % 12
            }
        }
    }
    val hrtext = if (hr == 1) "hour" else "hours"
    val dytext = if (dy == 1) "day" else "days"
    val mnthtext = if (mnth == 1) "month" else "months"
    return if (now.after(end)) {
        ""
    } else {
        var months = ""
        var days = ""
        var hours = ""
        months = if (mnth > 0) "$mnth $mnthtext" else ""
        if (mnth <= 0) {
            days = if (dy > 0) "$dy $dytext" else ""
            if (dy <= 0) {
                hours = if (hr > 0) "$hr $hrtext" else ""
            }
        }
        //Log.d("DATE", months + " 1 " + days + " 2 " + hours);
        months + days + hours
    }
}

/**
 * extension methods for logs.
 */

val Any.APP_TAG: String
    get() = "logGenix::" + this::class.simpleName

fun logV(tag: String, msg: String) {
    if (BuildConfig.DEBUG) Log.v(tag, msg)
}

// do something for a debug build
fun logD(tag: String, msg: String) {
    if (BuildConfig.DEBUG) Log.d(tag, msg)
}

fun logE(tag: String, msg: String) {
    if (BuildConfig.DEBUG) Log.e(tag, msg)
}


/**
 * extension methods for Toasts.
 */
fun showShort(context: Context, msg: String) {
    if (BuildConfig.DEBUG) Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
}

fun showReleaseShort(context: Context, msg: String) {
    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
}

// do something for a debug build
fun showLong(context: Context, msg: String) {
    if (BuildConfig.DEBUG) Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
}

// do something for a debug build
fun showReleaseLong(context: Context, msg: String) {
    Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
}


/**
 * extension methods for Views.
 */
fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}


fun getImeiOrDeviceId(context: Context): String {
    /* val tm =
         ContextCompat.getSystemService<Any>(context) as TelephonyManager?
     return tm!!.deviceId*/
    return ""
}

public fun logout(any: Any, activity: Activity) {
    try {
        if (any is Response<*>) {

        }
    } catch (e: Exception) {

    }
}

public fun extractNetworkErrorMsg(any: Any, activity: Activity): String {
    try {
        if (any is Response<*>) {
            if (any.errorBody() != null) {
                val msg2 = any.errorBody()!!.string()
                return if (msg2.isNullOrEmpty()) {
                    any.message()
                } else {
                    try {
                        val trimMsg = msg2.replace("\"", "")
                        trimMsg.trim()
                    } catch (e: Exception) {
                        any.message()

                    }
                }
            } else {
                return any.message()
            }
        } else {
            return activity.getString(R.string.networkError)
        }
    } catch (e: Exception) {
        return activity.getString(R.string.networkError)
    }
}
