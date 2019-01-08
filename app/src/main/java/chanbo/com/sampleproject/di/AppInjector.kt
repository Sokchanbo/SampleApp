package chanbo.com.sampleproject.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import chanbo.com.sampleproject.SampleApp
import chanbo.com.sampleproject.di.component.DaggerAppComponent
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection

object AppInjector {

    fun init(app: SampleApp) {
        DaggerAppComponent.builder()
            .application(app)
            .build()
            .inject(app)

        app.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
                handleActivity(activity)
            }

            override fun onActivityStarted(activity: Activity?) {
            }

            override fun onActivityResumed(activity: Activity?) {

            }

            override fun onActivityPaused(activity: Activity?) {

            }

            override fun onActivityStopped(activity: Activity?) {

            }

            override fun onActivityDestroyed(activity: Activity?) {

            }

            override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {

            }
        })
    }

    fun handleActivity(activity: Activity?) {
        AndroidInjection.inject(activity)
        if (activity is FragmentActivity) {
            activity.supportFragmentManager
                .registerFragmentLifecycleCallbacks(object : FragmentManager.FragmentLifecycleCallbacks() {
                    override fun onFragmentCreated(
                        fm: FragmentManager,
                        f: Fragment,
                        savedInstanceState: Bundle?) {

                        if (f is Injectable) {
                            AndroidSupportInjection.inject(f)
                        }
                    }
                }, true)
        }
    }
}