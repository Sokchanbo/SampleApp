package chanbo.com.sampleproject.di.module

import android.app.Application
import android.content.Context
import business.chanbo.com.sampleproject.BuildConfig
import chanbo.com.sampleproject.repository.AppRepository
import chanbo.com.sampleproject.repository.Repository
import chanbo.com.sampleproject.utils.rx.AppSchedulerProvider
import chanbo.com.sampleproject.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    internal fun provideSchedulerProvider(
        schedulerProvider: AppSchedulerProvider
    ) : SchedulerProvider = schedulerProvider

    @Provides
    @Singleton
    internal fun provideRepository(repository: AppRepository): Repository = repository

    @Provides
    @Singleton
    @Named("api_key")
    internal fun provideApiKey(): String = BuildConfig.API_KEY
}