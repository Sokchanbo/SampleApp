package chanbo.com.sampleproject.di.component

import chanbo.com.sampleproject.SampleApp
import chanbo.com.sampleproject.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ActivityBuildersModule::class,
        NetworkModule::class,
        AndroidSupportInjectionModule::class,
        ViewModelModule::class,
        FragmentBuildersModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: SampleApp): Builder

        fun build(): AppComponent
    }

    fun inject(app: SampleApp)
}