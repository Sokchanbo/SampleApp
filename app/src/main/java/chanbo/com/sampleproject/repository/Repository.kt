package chanbo.com.sampleproject.repository

import chanbo.com.sampleproject.data.remote.popular.PopularMovieResponse
import io.reactivex.Observable

interface Repository {

    fun getPopularMovie(): Observable<PopularMovieResponse>
}