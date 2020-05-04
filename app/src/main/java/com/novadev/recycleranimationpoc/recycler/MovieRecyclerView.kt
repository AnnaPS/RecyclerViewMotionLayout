package com.novadev.recycleranimationpoc.recycler

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView
import com.novadev.recycleranimationpoc.model.MovieEntity


class MovieRecyclerView : RecyclerView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)


    init {
        setHasFixedSize(true)
        adapter =  MovieAdapter(context)

    }

    fun update(movies: List<MovieEntity>, activity: MovieAdapter.OnMovieClicked) {
        (adapter as? MovieAdapter)?.submitList(movies)
        (adapter as? MovieAdapter)?.apply {
            callback = activity
        }
    }


}