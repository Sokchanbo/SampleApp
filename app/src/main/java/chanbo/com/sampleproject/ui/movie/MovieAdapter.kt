package chanbo.com.sampleproject.ui.movie

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import business.chanbo.com.sampleproject.R
import business.chanbo.com.sampleproject.databinding.LayoutMovieItemBinding
import chanbo.com.sampleproject.data.remote.popular.ResultsItem
import chanbo.com.sampleproject.ui.base.BaseViewHolder

class MovieAdapter(
    private val movies: MutableList<ResultsItem>
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    fun addMovies(movies: MutableList<ResultsItem>) {
        this@MovieAdapter.movies.clear()
        this@MovieAdapter.movies.addAll(movies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        position: Int
    ): MovieViewHolder =
        MovieViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.layout_movie_item,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class MovieViewHolder(
        private val binding: LayoutMovieItemBinding
    ) : BaseViewHolder(binding) {
        override fun bind(position: Int) {
            binding.movie = movies[position]
        }
    }
}