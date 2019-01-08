package chanbo.com.sampleproject.ui.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import chanbo.com.sampleproject.di.Injectable
import javax.inject.Inject

abstract class BaseFragment<VB : ViewDataBinding, VM : BaseViewModel<*>> : Fragment(), Injectable {

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory

    private var activity: BaseActivity<*, *>? = null

    protected lateinit var binding: VB
    protected lateinit var rootView: View

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract val bindingVariable: Int

    abstract val viewModel: VM

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        activity = context as BaseActivity<*, *>
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            getLayoutId(),
            container,
            false
        )
        rootView = binding.root
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setVariable(bindingVariable, viewModel)
        binding.executePendingBindings()
        onInitView(view, savedInstanceState)
    }

    protected fun showToast(message: String?) {
        Toast.makeText(activity, message ?: "", Toast.LENGTH_SHORT).show()
    }

    protected abstract fun onInitView(view: View, savedInstanceState: Bundle?)

    fun <T : ViewModel> injectViewModel(modelClass: Class<T>) =
        ViewModelProviders.of(this, mViewModelFactory)[modelClass]

}