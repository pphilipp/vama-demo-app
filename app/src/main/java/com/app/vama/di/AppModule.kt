package com.app.vama.di

import com.app.vama.data.AlbumsRepository
import com.app.vama.data.data_source.ApiDataSource
import com.app.vama.data.data_source.DataBaseDataSource
import com.app.vama.presentation.alboms.AlbumsViewModel
import com.app.vama.presentation.model.mapper.FeedResultToAlbumUiModelMapper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    //DataSource
    single { ApiDataSource(get()) }
    single { DataBaseDataSource() }

    // Repositories
    single { AlbumsRepository(get(), get()) }

    //presentation mappers
    single { FeedResultToAlbumUiModelMapper() }

    // ViewModel
    viewModel { AlbumsViewModel(get(), get()) }

}