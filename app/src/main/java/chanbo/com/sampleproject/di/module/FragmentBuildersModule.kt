package chanbo.com.sampleproject.di.module

import chanbo.com.sampleproject.ui.movie.MovieFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("UNUSED")
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeMovieFragment(): MovieFragment
}