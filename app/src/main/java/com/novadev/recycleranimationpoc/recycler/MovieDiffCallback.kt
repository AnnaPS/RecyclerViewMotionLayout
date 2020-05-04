package com.novadev.recycleranimationpoc.recycler

import androidx.recyclerview.widget.DiffUtil
import com.novadev.recycleranimationpoc.model.MovieEntity


class MovieDiffCallback : DiffUtil.ItemCallback<MovieEntity>() {

    override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity) =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity) =
        oldItem == newItem


}