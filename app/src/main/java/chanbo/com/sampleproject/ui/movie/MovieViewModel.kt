package chanbo.com.sampleproject.ui.movie

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableArrayList
import chanbo.com.sampleproject.data.remote.popular.ResultsItem
import chanbo.com.sampleproject.repository.Repository
import chanbo.com.sampleproject.ui.base.BaseViewModel
import javax.inject.Inject

class MovieViewModel @Inject constructor(
    private val repository: Repository
) : BaseViewModel<MovieNavigator>() {

    val movieObservableArrayList = ObservableArrayList<ResultsItem>()

    private val _movies = MutableLiveData<Any>()

    val movies: LiveData<Any>
        get() = _movies

    fun setMovies(movies: MutableList<ResultsItem>) {
        with(movieObservableArrayList) {
            clear()
            addAll(movies)
        }
    }

    fun getPopularMovie() {
        disposable.add(
            repository.getPopularMovie()
                .subscribe({
                    _movies.postValue(it)
                }, {
                    _movies.postValue(it)
                })

        )
    }
}