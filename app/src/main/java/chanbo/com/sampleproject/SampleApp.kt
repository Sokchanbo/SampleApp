package chanbo.com.sampleproject

import android.app.Activity
import android.app.Application
import business.chanbo.com.sampleproject.BuildConfig
import chanbo.com.sampleproject.di.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import javax.inject.Inject

class SampleApp : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingActivityInjector

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}