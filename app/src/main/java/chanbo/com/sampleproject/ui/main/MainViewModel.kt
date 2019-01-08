package chanbo.com.sampleproject.ui.main

import chanbo.com.sampleproject.repository.Repository
import chanbo.com.sampleproject.ui.base.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: Repository
) : BaseViewModel<MainNavigator>() {

}