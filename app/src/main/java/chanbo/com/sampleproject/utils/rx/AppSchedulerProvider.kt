package chanbo.com.sampleproject.utils.rx

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class AppSchedulerProvider @Inject constructor() : SchedulerProvider {

    override val io: Scheduler
        get() = Schedulers.io()

    override val ui: Scheduler
        get() = AndroidSchedulers.mainThread()

}