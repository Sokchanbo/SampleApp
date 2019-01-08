package chanbo.com.sampleproject.data

import chanbo.com.sampleproject.data.remote.popular.PopularMovieResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/popular")
    fun getPopularMovie(@Query("api_key") apiKey: String) : Observable<PopularMovieResponse>
}