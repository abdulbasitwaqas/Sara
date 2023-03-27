package com.jsbl.sara.di.components

import com.jsbl.sara.di.modules.APIModule
import com.jsbl.sara.di.modules.AppModule
import com.jsbl.sara.di.modules.PrefsModule
import com.jsbl.sara.viewModel.*
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(
    APIModule::class,
    PrefsModule::class,
    AppModule::class))
interface ServiceComponent {

    fun injectRegistration(viewModel: RegistrationViewModel)
    fun injectLogin(viewModel: LoginViewModel)
    fun injectDropDown(viewModel: ProfileManagementViewModel)
    fun injectIntoBaseViewModel(viewModel:BaseViewModel)

}