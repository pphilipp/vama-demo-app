package com.app.vama.presentation.alboms

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.vama.databinding.ItemAlmumBinding
import com.app.vama.presentation.model.AlbumUiModel
import com.bumptech.glide.Glide


class AlbumAdapter(
    private val onItemClickListener: (AlbumUiModel) -> Unit
) : ListAdapter<AlbumUiModel, AlbumAdapter.AlbumViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AlbumViewHolder = AlbumViewHolder(
        ItemAlmumBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val item = getItem(position)

        holder.binding.apply {
            root.setOnClickListener {
                onItemClickListener.invoke(item)
            }

            tvTitle.text = item.title
            tvSubtitle.text = item.subTitle

            Glide
                .with(ivPicture.context)
                .load(item.thumbnailUrl)
                .centerCrop()
                .into(ivPicture)
        }
    }

    class AlbumViewHolder(
        val binding: ItemAlmumBinding
    ) : RecyclerView.ViewHolder(binding.root)

    private class DiffCallback : DiffUtil.ItemCallback<AlbumUiModel>() {
        override fun areItemsTheSame(oldItem: AlbumUiModel, newItem: AlbumUiModel) =
            oldItem.title == newItem.title &&
                    oldItem.subTitle == newItem.subTitle &&
                    oldItem.thumbnailUrl == newItem.thumbnailUrl


        override fun areContentsTheSame(oldItem: AlbumUiModel, newItem: AlbumUiModel) =
            oldItem == newItem
    }
}