package com.app.vama.data.local

import androidx.room.*
import com.app.vama.data.local.model.AlbumArtistEntity
import com.app.vama.data.local.model.GenreEntity

@Dao
interface VamaDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addResultEntity(resultEntity: AlbumArtistEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addGenreEntity(resultEntity: GenreEntity)


    @Query("SELECT * FROM table_genre WHERE artist_related_Id = :artistId")
    suspend fun getGenreEntityByArtistId(artistId: String): List<GenreEntity>


    @Query("SELECT * FROM table_album_artist")
    suspend fun getAllAlbums(): List<AlbumArtistEntity>

    @Query("SELECT * FROM table_album_artist WHERE id = :id")
    suspend fun getAllAlbumById(id: String): AlbumArtistEntity

}