package chanbo.com.sampleproject.repository

import chanbo.com.sampleproject.data.MovieApi
import chanbo.com.sampleproject.data.remote.popular.PopularMovieResponse
import chanbo.com.sampleproject.utils.rx.SchedulerProvider
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Named

class AppRepository @Inject constructor(
    private val api: MovieApi,
    private val provider: SchedulerProvider,
    @Named("api_key") private val apiKey: String
) : Repository {

   /* private lateinit var api: MovieApi
    private lateinit var provider: SchedulerProvider

    constructor(api: MovieApi, provider: SchedulerProvider) {
        this@AppRepository.api = api
    }*/

    override fun getPopularMovie(): Observable<PopularMovieResponse> =
         api.getPopularMovie(apiKey)
             .subscribeOn(provider.io)
             .observeOn(provider.ui)
}