package com.app.vama.domain

import com.app.vama.data.AlbumsRepository
import com.app.vama.data.remote.model.FeedData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetAlbumsListUseCase(
    private val albumsRepository: AlbumsRepository,
) : UseCase<Flow<FeedData?>, GetAlbumsListUseCase.Params> {

    data class Params(val amount: Int)

    override fun execute(params: Params): Flow<FeedData?> = flow {
        emit(albumsRepository.getAlbumsList(params.amount))
    }
}