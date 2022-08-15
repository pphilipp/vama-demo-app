package com.app.vama.data.mapper

import com.app.vama.data.local.model.GenreEntity
import com.app.vama.data.remote.model.GenreData
import com.app.vama.util.EMPTY_STRING

class GenresDataToGenresEntityMapper {

    fun map(from: GenreData): GenreEntity = GenreEntity(
        genreId = from.genreId ?: EMPTY_STRING,
        name = from.name ?: EMPTY_STRING,
        url = from.url ?: EMPTY_STRING
    )
}
