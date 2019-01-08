package chanbo.com.sampleproject.ui.base

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference

abstract class BaseViewModel<N> : ViewModel() {

    protected val disposable = CompositeDisposable()

    private var mNavigator: WeakReference<N>? = null

    fun setNavigator(navigator: N) {
        mNavigator = WeakReference(navigator)
    }

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }
}