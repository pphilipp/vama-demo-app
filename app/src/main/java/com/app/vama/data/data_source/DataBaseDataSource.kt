package com.app.vama.data.data_source

import com.app.vama.data.local.VamaDAO
import com.app.vama.data.local.model.AlbumArtistEntity
import com.app.vama.data.local.model.GenreEntity

class DataBaseDataSource(
    private val vamaDAO: VamaDAO
) {

    suspend fun saveResultEntity(resultEntity: AlbumArtistEntity) =
        vamaDAO.addResultEntity(resultEntity)

    suspend fun saveGenreEntity(genreEntity: GenreEntity) =
        vamaDAO.addGenreEntity(genreEntity)

    suspend fun getGenreEntityByArtistId(artistId: String): List<GenreEntity> =
        vamaDAO.getGenreEntityByArtistId(artistId)

    suspend fun getAllAlbums(): List<AlbumArtistEntity> = vamaDAO.getAllAlbums()

    suspend fun getAllAlbum(
        id: String
    ): AlbumArtistEntity = vamaDAO.getAllAlbumById(id)


}