package com.novadev.recycleranimationpoc.recycler

import android.content.Context
import android.graphics.Outline
import android.view.View
import android.view.ViewOutlineProvider
import com.novadev.recycleranimationpoc.extension.toPx
import com.novadev.recycleranimationpoc.model.MovieEntity
import kotlinx.android.synthetic.main.movie_item.view.*


open class MovieItemViewHolder(view: View) : BaseViewHolder(view){
    fun bind(
        item: MovieEntity,
        position: Int,
        context: Context,
        callback: MovieAdapter.OnMovieClicked
    )=with(itemView) {
        tvName.text = item.name
        tvSynopsis.text = item.synopsis
        initHeaderImage(context, ivItem)
        ivItem.setBackgroundColor(ivItem.resources.getColor(item.background))
    }


    private fun initHeaderImage(context: Context, itemView: View) {
        val radius = 12F.toPx(context)
        itemView.ivItem.outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View, outline: Outline) {
                outline.setRoundRect( 0, -radius.toInt(), view.width, view.height, radius)
            }
        }
        itemView.ivItem.clipToOutline = true
    }
}