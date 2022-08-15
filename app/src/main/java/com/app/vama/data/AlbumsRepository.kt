package com.app.vama.data

import com.app.vama.data.data_source.ApiDataSource
import com.app.vama.data.data_source.DataBaseDataSource
import com.app.vama.data.local.model.GenreEntity
import com.app.vama.data.mapper.GenresDataToGenresEntityMapper
import com.app.vama.data.mapper.ResultDataToAlbumArtistEntityMapper
import com.app.vama.data.remote.model.FeedData
import com.app.vama.util.EMPTY_STRING

class AlbumsRepository(
    private val apiDataSource: ApiDataSource,
    private val dataBaseDataSource: DataBaseDataSource,
    private val resultDataToResultEntityMapper: ResultDataToAlbumArtistEntityMapper,
    private val genresDataToGenresEntityMapper: GenresDataToGenresEntityMapper,
) {

    suspend fun getAlbumsList(amount: Int): FeedData? =
        apiDataSource.fetchAlbums(amount)
            ?.also { feedData ->
                feedData.results
                    ?.forEach { resultEntity ->
                        dataBaseDataSource.saveResultEntity(
                            resultDataToResultEntityMapper.map(resultEntity)
                        )

                        resultEntity.genres?.map {
                            val genre = genresDataToGenresEntityMapper.map(it)
                                .copy(artistId = resultEntity.id ?: EMPTY_STRING)
                            saveGenre(genre)
                        }
                    }
            }

    suspend fun getAlbumById(
        albumId: String
    ) = dataBaseDataSource.getAllAlbum(albumId)

    suspend fun saveGenre(
        genreEntity: GenreEntity
    ) = dataBaseDataSource.saveGenreEntity(genreEntity)

    suspend fun getCashedAllAlbums() =
        dataBaseDataSource.getAllAlbums()

    suspend fun getGenreEntityByArtistId(id: String) =
        dataBaseDataSource.getGenreEntityByArtistId(id)

}