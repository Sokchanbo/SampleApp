package chanbo.com.sampleproject.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import chanbo.com.sampleproject.di.ViewModelKey
import chanbo.com.sampleproject.di.ViewModelProviderFactory
import chanbo.com.sampleproject.ui.main.MainViewModel
import chanbo.com.sampleproject.ui.movie.MovieViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("UNUSED")
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MovieViewModel::class)
    internal abstract fun bindMovieViewModel(movieViewModel: MovieViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelProviderFactory) : ViewModelProvider.Factory

}