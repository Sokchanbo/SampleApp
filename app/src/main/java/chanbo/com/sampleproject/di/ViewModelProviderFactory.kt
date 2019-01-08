package chanbo.com.sampleproject.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton


@Suppress("UNCHECKED_CAST")
@Singleton
class ViewModelProviderFactory @Inject constructor(
    private val viewModelMaps: Map<Class<out ViewModel>,
            @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val creator = viewModelMaps[modelClass] ?: viewModelMaps.asIterable().firstOrNull {
            modelClass.isAssignableFrom(it.key)
        }?.value ?: throw IllegalArgumentException("unknown model class $modelClass")
        return try {
            creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}