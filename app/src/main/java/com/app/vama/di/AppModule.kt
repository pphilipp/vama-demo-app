package com.app.vama.di

import com.app.vama.presentation.alboms.AlbumsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    // ViewModel for Detail View
    viewModel { AlbumsViewModel() }

}