package chanbo.com.sampleproject.ui.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import javax.inject.Inject

abstract class BaseActivity<VB: ViewDataBinding, VM: BaseViewModel<*>> : AppCompatActivity() {

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory

    protected lateinit var binding: VB

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract val bindingVariable: Int

    abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        binding.setVariable(bindingVariable, viewModel)
        binding.executePendingBindings()

        onInitView(savedInstanceState)
    }

    protected fun showToast(message: String?) {
        Toast.makeText(this, message ?: "", Toast.LENGTH_SHORT).show()
    }

    protected abstract fun onInitView(savedInstanceState: Bundle?)

    fun<T : ViewModel> injectViewModel(modelClass: Class<T>) =
            ViewModelProviders.of(this, mViewModelFactory)[modelClass]

}