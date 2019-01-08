package chanbo.com.sampleproject.di.module

import business.chanbo.com.sampleproject.BuildConfig
import chanbo.com.sampleproject.data.MovieApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    internal fun provideRetrofit(
        client: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit =
            Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(client)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

    @Provides
    @Singleton
    internal fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient =
            OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build()

    @Provides
    @Singleton
    internal fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor {
            Timber.d("Log $it")
        }.setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    internal fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory =
            GsonConverterFactory.create(gson)

    @Provides
    @Singleton
    internal fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    internal fun provideMovieApi(retrofit: Retrofit): MovieApi =
            retrofit.create(MovieApi::class.java)

}