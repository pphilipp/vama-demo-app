package com.app.vama.presentation.alboms

import androidx.lifecycle.ViewModel
import com.app.vama.presentation.model.AlbumUiModel
import kotlinx.coroutines.flow.flow

class AlbumsViewModel : ViewModel() {

    fun getMockList() = flow {
        emit(mockList + mockList)
    }

}

val mockList = listOf(
    AlbumUiModel(
        "title 1",
        "subtitle 1",
        "https://linuxhint.com/wp-content/uploads/2021/07/Generate-Random-String-Bash-01.png"
    ),
    AlbumUiModel(
        "title 2",
        "subtitle 2",
        "https://linuxhint.com/wp-content/uploads/2021/07/Generate-Random-String-Bash-01.png"
    ),
    AlbumUiModel(
        "title 3",
        "subtitle 3",
        "https://linuxhint.com/wp-content/uploads/2021/07/Generate-Random-String-Bash-01.png"
    ),
    AlbumUiModel(
        "title 4",
        "subtitle 4",
        "https://linuxhint.com/wp-content/uploads/2021/07/Generate-Random-String-Bash-01.png"
    ),
    AlbumUiModel(
        "title 5",
        "subtitle 5",
        "https://linuxhint.com/wp-content/uploads/2021/07/Generate-Random-String-Bash-01.png"
    ),
    AlbumUiModel(
        "title 6",
        "subtitle 6",
        "https://linuxhint.com/wp-content/uploads/2021/07/Generate-Random-String-Bash-01.png"
    ),
    AlbumUiModel(
        "title 7",
        "subtitle 7",
        "https://linuxhint.com/wp-content/uploads/2021/07/Generate-Random-String-Bash-01.png"
    ),
)