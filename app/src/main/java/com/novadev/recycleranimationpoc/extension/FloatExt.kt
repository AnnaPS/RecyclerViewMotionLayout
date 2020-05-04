package com.novadev.recycleranimationpoc.extension

import android.content.Context

fun Float.toPx(context: Context) = this * context.resources.displayMetrics.density