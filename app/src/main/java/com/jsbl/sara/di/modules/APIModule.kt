package com.jsbl.sara.di.modules

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jsbl.sara.BuildConfig
import com.jsbl.sara.network.LocalApi
import com.jsbl.sara.network.LocalService
import com.jsbl.sara.utils.SharePreferencesHelper
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.KeyStore
import java.util.concurrent.TimeUnit


@Module
class APIModule {

    @Provides
    fun provideOkHttpClient(application: Application): OkHttpClient {
        return generateSecureOkHttpClient(application)
    }


    @Provides
    fun provideNetworkApi(client: OkHttpClient): LocalApi {
        val gson: Gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()

        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(LocalApi::class.java)
    }

    @Provides
//    @typeOfService(API_SERVIE_LOCAL)
    fun provideRegistrationService(application: Application): LocalService {
        return LocalService(application)
    }


    private fun generateSecureOkHttpClient(application: Context): OkHttpClient {

        var preferencesHelper: SharePreferencesHelper = SharePreferencesHelper(application)
        val logger = HttpLoggingInterceptor()
        logger.level = if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY
        else HttpLoggingInterceptor.Level.NONE

        var httpClientBuilder = getUnsafeOkHttpClient(application)
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(180, TimeUnit.SECONDS)
            .writeTimeout(180, TimeUnit.SECONDS)
            .readTimeout(180, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .addInterceptor(logger)
            .addInterceptor(object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): Response {
                    val original: Request = chain.request()
                    val request: Request = original.newBuilder()
                        .header("Accept", "application/json")
//                        .addHeader("Authorization", "Bearer " + preferencesHelper.getAuth())
//                        .header("USER",preferencesHelper.encryptUserId(preferencesHelper.getCustomerId().toString()))
                        .method(original.method, original.body)
                        .build()
//                    logD("**encryptedUserID","encrpted user ID :" +preferencesHelper.encryptUserId(preferencesHelper.getCustomerId().toString()))
                    return chain.proceed(request)
                }
            })
            .build()
        return httpClientBuilder
    }

    private fun getUnsafeOkHttpClient(mContext: Context):
            OkHttpClient.Builder {
        val mKeyStoreType = KeyStore.getDefaultType()
        val mKeyStore = KeyStore.getInstance(mKeyStoreType)
        mKeyStore.load(null, null)
        val builder = OkHttpClient.Builder()
        builder.hostnameVerifier { _, _ -> true }
        return builder
    }
}
