package com.app.vama.domain

import com.app.vama.data.AlbumsRepository
import com.app.vama.presentation.model.AlbumWithGenresUiModel
import com.app.vama.presentation.model.GenreUiModel
import com.app.vama.presentation.model.mapper.AlbumArtistEntityToAlbumUiModelMapper
import com.app.vama.presentation.model.mapper.GenreEntityToGenreUiModelMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetAlbumByIdUseCase(
    private val albumsRepository: AlbumsRepository,
    private val albumArtistEntityToAlbumUiModelMapper: AlbumArtistEntityToAlbumUiModelMapper,
    private val genreEntityToGenreUiModelMapper: GenreEntityToGenreUiModelMapper,
) : UseCase<Flow<AlbumWithGenresUiModel>, GetAlbumByIdUseCase.GetAlbumByIdUseCaseParams> {

    data class GetAlbumByIdUseCaseParams(val id: String)

    override fun execute(params: GetAlbumByIdUseCaseParams): Flow<AlbumWithGenresUiModel> = flow {
        val genreList: List<GenreUiModel> = albumsRepository.getGenreEntityByArtistId(params.id)
            .map {
                genreEntityToGenreUiModelMapper.map(it)
            }
        val albumWithGenresUiModel = AlbumWithGenresUiModel(
            albumUiModel = albumArtistEntityToAlbumUiModelMapper.map(
                from = albumsRepository.getAlbumById(params.id)
            ),
            genreList = genreList
        )

        emit(albumWithGenresUiModel)
    }
}