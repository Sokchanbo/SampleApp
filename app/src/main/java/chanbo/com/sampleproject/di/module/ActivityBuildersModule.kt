package chanbo.com.sampleproject.di.module

import chanbo.com.sampleproject.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("UNUSED")
@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}