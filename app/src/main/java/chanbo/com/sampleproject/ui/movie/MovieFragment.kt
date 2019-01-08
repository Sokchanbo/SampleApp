package chanbo.com.sampleproject.ui.movie


import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.View
import business.chanbo.com.sampleproject.BR
import business.chanbo.com.sampleproject.R
import business.chanbo.com.sampleproject.databinding.FragmentMovieBinding
import chanbo.com.sampleproject.data.remote.popular.PopularMovieResponse
import chanbo.com.sampleproject.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_movie.*
import timber.log.Timber


class MovieFragment : BaseFragment<FragmentMovieBinding, MovieViewModel>() {

    private lateinit var adapter: MovieAdapter

    override fun getLayoutId(): Int = R.layout.fragment_movie

    override val bindingVariable: Int
        get() = BR.viewModel

    override val viewModel: MovieViewModel
        get() = injectViewModel(MovieViewModel::class.java)

    override fun onInitView(view: View, savedInstanceState: Bundle?) {

        adapter = MovieAdapter(ArrayList())

        recyclerView.layoutManager = GridLayoutManager(view.context, 2, GridLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter

        viewModel.getPopularMovie()

        subscribeLiveData()
    }

    private fun subscribeLiveData() {
        viewModel.movies.observe(this, Observer {
            when (it) {
                is PopularMovieResponse -> {
                    viewModel.setMovies(it.results!!.toMutableList())
                }
                is Throwable -> {
                    Timber.e("subscribeLiveData: ${it.localizedMessage}")
                }
            }
        })
    }

    companion object {
        fun newInstance() = MovieFragment()
    }
}
