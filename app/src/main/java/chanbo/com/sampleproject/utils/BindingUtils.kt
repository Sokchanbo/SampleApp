package chanbo.com.sampleproject.utils

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import chanbo.com.sampleproject.data.remote.popular.ResultsItem
import chanbo.com.sampleproject.ui.movie.MovieAdapter
import com.bumptech.glide.Glide

object BindingUtils {

    @BindingAdapter("adapter")
    @JvmStatic
    fun addPopularMovie(
        recyclerView: RecyclerView,
        movies: MutableList<ResultsItem>
    ) {
        val adapter = recyclerView.adapter as MovieAdapter?
        adapter?.addMovies(movies)
    }

    @BindingAdapter("thumbnail")
    @JvmStatic
    fun setThumbnail(
        imageView: ImageView,
        url: String
    ) {
        Glide.with(imageView.context)
            .load("https://image.tmdb.org/t/p/w500/$url")
            .into(imageView)
    }
}