package com.novadev.recycleranimationpoc.recycler

import android.content.Context
import android.graphics.Outline
import android.view.View
import android.view.ViewOutlineProvider
import com.novadev.recycleranimationpoc.extension.toPx
import com.novadev.recycleranimationpoc.model.MovieEntity
import kotlinx.android.synthetic.main.movie_item_header.view.*


open class MovieHeaderViewHolder(view: View) : BaseViewHolder(view){
    fun bind(
        item: MovieEntity,
        position: Int,
        context: Context,
        callback: MovieAdapter.OnMovieClicked
    ) = with(itemView) {
        initHeaderImage(context, ivHeader)

        tvName.text = item.name
        tvDirector.text = item.director
        tvSynopsis.text = item.synopsis
        ivHeader.setBackgroundColor(ivHeader.resources.getColor(item.background))
    }




    private fun initHeaderImage(context: Context, itemView: View) {
        val radius = 12F.toPx(context)
        itemView.ivHeader.outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View, outline: Outline) {
                outline.setRoundRect(0, -radius.toInt(), view.width, view.height, radius)
            }
        }
        itemView.ivHeader.clipToOutline = true
    }




}