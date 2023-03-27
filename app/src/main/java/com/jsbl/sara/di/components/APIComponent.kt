package com.jsbl.sara.di.components

import com.jsbl.sara.di.modules.APIModule
import com.jsbl.sara.di.modules.AppModule
import com.jsbl.sara.network.LocalService
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(APIModule::class,AppModule::class))
interface APIComponent {

    fun injectAPI(service: LocalService)

}