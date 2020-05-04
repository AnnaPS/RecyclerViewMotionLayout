package com.novadev.recycleranimationpoc.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.novadev.recycleranimationpoc.R
import com.novadev.recycleranimationpoc.model.MovieEntity


class MovieAdapter(var context: Context) : ListAdapter<MovieEntity, BaseViewHolder>(
    MovieDiffCallback()
) {
    var callback: OnMovieClicked? = null


    companion object{
        const val HEADER = 1
        const val ITEM = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            HEADER -> {
                val v = LayoutInflater.from(parent.context)
                    .inflate(R.layout.movie_item_header, parent, false)
                return MovieHeaderViewHolder(
                    v
                )
            }
            ITEM -> {
                val v = LayoutInflater.from(parent.context)
                    .inflate(R.layout.movie_item, parent, false)
                return MovieItemViewHolder(
                    v
                )
            }

            else -> {
                val v = LayoutInflater.from(parent.context)
                    .inflate(R.layout.movie_item, parent, false)
                return MovieItemViewHolder(
                    v
                )
            }
        }

    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when(getItemViewType(position)){
            HEADER ->{
                holder as MovieHeaderViewHolder
                callback?.let { holder.bind(getItem(position), position, context, it) }
            }
            ITEM ->{
                holder as MovieItemViewHolder
                callback?.let { holder.bind(getItem(position), position, context,it) }
            }

        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(position){
            0 -> HEADER
            else -> ITEM
        }
    }

    interface OnMovieClicked {
        fun onMovieClicked(movieEntity: MovieEntity)
    }
}