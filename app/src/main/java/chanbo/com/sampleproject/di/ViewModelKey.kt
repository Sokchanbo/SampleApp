package chanbo.com.sampleproject.di

import android.arch.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.PROPERTY_GETTER)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)