package com.app.vama.di

import com.app.vama.data.AlbumsRepository
import com.app.vama.data.data_source.ApiDataSource
import com.app.vama.data.data_source.DataBaseDataSource
import com.app.vama.data.mapper.*
import com.app.vama.presentation.album_details.AlbumDetailsViewModel
import com.app.vama.presentation.albums.AlbumsViewModel
import com.app.vama.presentation.model.mapper.AlbumArtistEntityToAlbumUiModelMapper
import com.app.vama.presentation.model.mapper.FeedResultToAlbumUiModelMapper
import com.app.vama.presentation.model.mapper.GenreEntityToGenreUiModelMapper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    //DataSource
    single { ApiDataSource(get()) }
    single { DataBaseDataSource(get()) }
    //DataSource mappers
    single { GenresDataToGenresEntityMapper() }
    single { ResultDataToAlbumArtistEntityMapper() }

    // Repositories
    single { AlbumsRepository(get(), get(), get(), get()) }

    //presentation mappers
    single { FeedResultToAlbumUiModelMapper() }
    single { AlbumArtistEntityToAlbumUiModelMapper() }
    single { GenreEntityToGenreUiModelMapper() }

    // ViewModel
    viewModel { AlbumsViewModel(get(), get(), get()) }
    viewModel { AlbumDetailsViewModel(get(), get(), get()) }

}