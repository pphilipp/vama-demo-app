package com.app.vama.domain

import com.app.vama.data.AlbumsRepository
import com.app.vama.data.local.model.AlbumArtistEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetAllCashedAlbumsUseCase(
    private val albumsRepository: AlbumsRepository,
): UseCase<Flow<List<AlbumArtistEntity>>, Nothing?> {

    override fun execute(params: Nothing?): Flow<List<AlbumArtistEntity>> =  flow {
        emit(albumsRepository.getCashedAllAlbums())
    }

}